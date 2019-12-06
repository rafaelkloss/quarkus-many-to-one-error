package com.proposito.model.project;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.proposito.model.AbstractModel;
import com.proposito.model.usuario.Usuario;

/**
 * Entidade responsável por armazenar os inputs que os {@link Usuario}
 * colaboradores fazem nos {@link Projeto}s. IMPORTANTE: CONCEITO DE TABELA FATO
 * !
 * 
 * @author kloss
 *
 */
@Entity(name = "InputProjeto")
@Table(name = "inputs_projeto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 30)
public abstract class InputProjeto extends AbstractModel {

	@Id
	@SequenceGenerator(name = "inputSequence", sequenceName = "input_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inputSequence")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`idParticipante`")
	private ParticipacaoProjeto participante;

	/**
	 * Quando necessário um input numérico
	 */
	@Column(name = "`valorNumerico`")
	private Integer valorNumerico;

	/**
	 * Se necessário, inserir um percentual do input, principalmente quando
	 * {@link CaracteristicaInput#PARCIAL}
	 */
	private Double percentual;

	/**
	 * Quando necessário um agendamento com algum texto
	 */
	@Column(columnDefinition = "TEXT")
	private String descricao;

	/**
	 * Quando necessário um input com valor escrito
	 */
	@Column(name = "`valorDescricao`")
	private String valorDescricao;

	@Column(name = "`dataCriacao`", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataCriacao = OffsetDateTime.now();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ParticipacaoProjeto getParticipante() {
		return participante;
	}

	public void setParticipante(ParticipacaoProjeto participante) {
		this.participante = participante;
	}

	public Integer getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(Integer valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getValorDescricao() {
		return valorDescricao;
	}

	public void setValorDescricao(String valorDescricao) {
		this.valorDescricao = valorDescricao;
	}

	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
