package com.proposito.model.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.proposito.model.AbstractModel;
import com.proposito.model.AbstractModelDeletavel;
import com.proposito.model.HasLogAndCliente;
import com.proposito.model.cliente.Cliente;
import com.proposito.model.core.feature.Feature;
import com.proposito.model.util.LogRegistro;

/**
 * Entidade responsável por armazenar os diversos projetos de um cliente, que
 * devem ser utilizados em conjunto com os {@link Recurso}s disponíveis.
 * 
 * @author kloss
 *
 */
@Entity(name = "Projeto")
@Table(name = "projeto")
public class Projeto extends AbstractModel implements HasLogAndCliente {

	@Id
	@SequenceGenerator(name = "projetoSequence", sequenceName = "projeto_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projetoSequence")
	private Integer id;

	@Column(length = 200, nullable = false)
	private String nome;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Column(nullable = false)
	private Boolean ativo = true;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "`idConfiguracaoProjeto`")
	private ConfiguracaoProjeto configuracao;

	@Embedded
	private LogRegistro log = new LogRegistro();

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`idCliente`")
	private Cliente cliente;

	/**
	 * QUando deletadas, as deleçÕes são feitas logicamente, vide
	 * {@link AbstractModelDeletavel}.
	 */
	@Where(clause = "deletado = false")
	@OneToMany(targetEntity = ParticipacaoProjeto.class, cascade = CascadeType.ALL, mappedBy = "projeto")
	private List<ParticipacaoProjeto> participacoes = new ArrayList<ParticipacaoProjeto>();

	/**
	 * Todos os projetos são ou fazem parte de uma {@link Feature}
	 * 
	 * @return
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false, name = "`feature`")
	private Feature mainFeature = Feature.Teste;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Feature getMainFeature() {
		return mainFeature;
	}

	public void setMainFeature(Feature mainFeature) {
		this.mainFeature = mainFeature;
	}

	public LogRegistro getLog() {
		return log;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public ConfiguracaoProjeto getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(ConfiguracaoProjeto configuracao) {
		this.configuracao = configuracao;
	}

	public void setLog(LogRegistro log) {
		this.log = log;
	}

	public List<ParticipacaoProjeto> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<ParticipacaoProjeto> participacoes) {
		this.participacoes = participacoes;
	}

}
