package com.proposito.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.proposito.dao.contract.AbstractDAOInterface;
import com.proposito.model.AbstractModel;
import com.proposito.model.AbstractModelDeletavel;
import com.proposito.model.HasToggleAtivo;

public abstract class AbstractDAOImpl implements AbstractDAOInterface {

	@Inject
	protected EntityManager entityManager;

	@ConfigProperty(name = "pro.sql.maximum")
	protected Integer maxResultsSemFiltro;

	/**
	 * {@inheritDoc}
	 */
	public AbstractModel persist(AbstractModel entidadePersistente) {
		entityManager.persist(entidadePersistente);
		entityManager.flush();
		return entidadePersistente;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removerLogicamente(AbstractModelDeletavel deletavel) {
		deletavel.setDeletado(Boolean.TRUE);
		persist(deletavel);
	}

	/**
	 * Retorna um objeto de acordo com seu id
	 * 
	 * @param clazz - que estende {@link AbstractModel}
	 * @param id    - id da entidade
	 * @return - único objeto com o id em questão
	 */
	public AbstractModel getById(Class<? extends AbstractModel> clazz, final Object id) {
		return entityManager.find(clazz, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends AbstractModel> existsByStringValue(Class<? extends AbstractModel> clazz, String field,
			String value) {
		final String hql = "select o from " + clazz.getName() + "  o where o." + field + " = :value";
		final Query query = entityManager.createQuery(hql);
		query.setParameter("value", value);
		@SuppressWarnings("unchecked")
		final List<? extends AbstractModel> list = query.getResultList();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public List<? extends AbstractModel> existsByStringValueAndCliente(Class<? extends AbstractModel> clazz,
			String field, String value, Integer idCliente) {
		final String hql = "select o from " + clazz.getName() + "  o where o.cliente.id = :idCliente and o." + field
				+ " = :value";
		final Query query = entityManager.createQuery(hql);
		query.setParameter("idCliente", idCliente);
		query.setParameter("value", value);
		@SuppressWarnings("unchecked")
		final List<? extends AbstractModel> list = query.getResultList();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public List<? extends AbstractModel> existsByStringValueAndClienteNotThisId(Class<? extends AbstractModel> clazz,
			String field, String value, Integer idCliente, Integer thisId) {
		final String hql = "select o from " + clazz.getName()
				+ "  o where o.id <> :thisId and o.cliente.id = :idCliente and o." + field + " = :value";
		final Query query = entityManager.createQuery(hql);
		query.setParameter("thisId", thisId);
		query.setParameter("idCliente", idCliente);
		query.setParameter("value", value);
		@SuppressWarnings("unchecked")
		final List<? extends AbstractModel> list = query.getResultList();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<? extends AbstractModel> getAllByIdCliente(Class<? extends AbstractModel> clazz, Integer idCliente) {
		final String hql = "select o from " + clazz.getName() + "  o where o.cliente.id = :idCliente";
		final Query query = entityManager.createQuery(hql);
		query.setParameter("idCliente", idCliente);
		@SuppressWarnings("unchecked")
		final List<? extends AbstractModel> list = query.getResultList();
		return list;
	}

	public List<? extends HasToggleAtivo> getAllAtivosByIdCliente(Class<? extends HasToggleAtivo> clazz,
			Integer idCliente, Boolean ativo) {
		final String hql = "select o from " + clazz.getName()
				+ "  o where o.cliente.id = :idCliente and ativo = :ativo";
		final Query query = entityManager.createQuery(hql);
		query.setParameter("idCliente", idCliente);
		query.setParameter("ativo", ativo);
		@SuppressWarnings("unchecked")
		final List<? extends HasToggleAtivo> list = query.getResultList();
		return list;
	}

	/**
	 * Gera uma lista de inteiros separados por vírgula para ser usado como replace
	 * ao fazer uma query nativa Workarround, pois não consegui fazer a
	 * query.setParameter aceitar arrays.
	 * 
	 * @param integers
	 * @return
	 */
	protected String getInWithIntegers(final List<Integer> integers) {
		if (integers.size() > 0) {
			StringBuilder nameBuilder = new StringBuilder();

			for (Integer n : integers) {
				nameBuilder.append(n.toString()).append(",");
			}

			nameBuilder.deleteCharAt(nameBuilder.length() - 1);
			return nameBuilder.toString();
		} else {
			return "0";
		}
	}
}
