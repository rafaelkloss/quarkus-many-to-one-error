package com.proposito.model.project;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.proposito.model.AbstractModel;
import com.proposito.model.core.feature.MainFeature;

/**
 * Entidade responsável por armazenar a configuracao de um {@link Projeto}.
 * 
 * @author kloss
 *
 */
@Entity(name = "ConfiguracaoProjeto")
@Table(name = "configuracao_projeto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 30)
public abstract class ConfiguracaoProjeto extends AbstractModel implements MainFeature {

	@Id
	@SequenceGenerator(name = "configuracaoProjetoSequence", sequenceName = "configuracao_projeto_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuracaoProjetoSequence")
	private Integer id;

	/**
	 * Data que o {@link Projeto} deve iniciar.
	 */
	@Column(name = "`dataInicio`")
	private LocalDate dataInicio;

	/**
	 * Data limite para respostas
	 */
	@Column(name = "`dataFim`")
	private LocalDate dataFim;

	/**
	 * Data de conclusão do projeto.
	 */
	@Column(name = "`dataConclusao`")
	private LocalDate dataConclusao;

	/**
	 * Exibir um campo para observações finais após todas as respostas de acordo com
	 * os recursos e indicadores.
	 */
	@Column(name = "`permiteObservacaoNoFinal`", nullable = false)
	private Boolean permiteObservacaoNoFinal = Boolean.FALSE;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Boolean getPermiteObservacaoNoFinal() {
		return permiteObservacaoNoFinal;
	}

	public void setPermiteObservacaoNoFinal(Boolean permiteObservacaoNoFinal) {
		this.permiteObservacaoNoFinal = permiteObservacaoNoFinal;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

}
