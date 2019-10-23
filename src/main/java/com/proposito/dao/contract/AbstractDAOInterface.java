package com.proposito.dao.contract;

import java.util.List;

import com.proposito.model.AbstractModel;
import com.proposito.model.AbstractModelDeletavel;
import com.proposito.model.HasToggleAtivo;
import com.proposito.model.cliente.Cliente;

public interface AbstractDAOInterface {

	/**
	 * Persiste (persist & merge) um objeto filho de {@link AbstractModel} no banco
	 * de dados.
	 * 
	 * @param obj
	 * @return o objeto persisitdo
	 */
	public AbstractModel persist(AbstractModel obj);

	/**
	 * Remove uma {@link AbstractModelDeletavel} logicamente. deletado = true
	 * 
	 * @param objeto deletável
	 */
	public void removerLogicamente(final AbstractModelDeletavel deletavel);

	/**
	 * Retorna um objeto de acordo com seu id
	 * 
	 * @param clazz - que estende {@link AbstractModel}
	 * @param id    - id da entidade
	 * @return - único objeto com o id em questão
	 */
	public AbstractModel getById(Class<? extends AbstractModel> clazz, final Object id);

	/**
	 * Verifica se existe a entidade no banco de dados de acordo com a model
	 * (clazz), field e value do field.
	 * 
	 * @param clazz - classe que extende {@link AbstractModel}
	 * @param field - field dessa classe
	 * @param value - valor para critério de pesquisa
	 * @return lista caso encontre, null caso não
	 */
	public List<? extends AbstractModel> existsByStringValue(Class<? extends AbstractModel> clazz, String field,
			String value);

	/**
	 * Verifica se existe a entidade no banco de dados de acordo com a model
	 * (clazz), field e value do field além do idCliente.
	 * 
	 * @param clazz     - classe que extende {@link AbstractModel}
	 * @param field     - field dessa classe
	 * @param value     - valor para critério de pesquisa
	 * @param idCliente - id do {@link Cliente} para averiquação
	 * @return lista caso encontre, null caso não
	 */
	public List<? extends AbstractModel> existsByStringValueAndCliente(Class<? extends AbstractModel> clazz,
			String field, String value, Integer idCliente);

	/**
	 * Verifica se já existe no banco de dados com id diferente e descrição igual
	 * para o mesmo cliente
	 * 
	 * @param clazz
	 * @param field
	 * @param value
	 * @param idCliente
	 * @param thisId
	 * @return
	 */
	public List<? extends AbstractModel> existsByStringValueAndClienteNotThisId(Class<? extends AbstractModel> clazz,
			String field, String value, Integer idCliente, Integer thisId);

	/**
	 * Retorna uma lista de objetos de um cliente
	 * 
	 * @param clazz
	 * @param idCliente
	 * @return
	 */
	public List<? extends AbstractModel> getAllByIdCliente(Class<? extends AbstractModel> clazz, Integer idCliente);

	/**
	 * Retorna uma lista de objetos de um cliente, ativos ou não, de acordo com a
	 * argumentação
	 * 
	 * @param clazz
	 * @param idCliente
	 * @param ativo     true or false (vide coluna ativo nos modelos que implementam
	 *                  {@link HasToggleAtivo})
	 * @return
	 */
	public List<? extends HasToggleAtivo> getAllAtivosByIdCliente(Class<? extends HasToggleAtivo> clazz,
			Integer idCliente, Boolean ativo);

}
