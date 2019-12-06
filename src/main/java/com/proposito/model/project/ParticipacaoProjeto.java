package com.proposito.model.project;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;

import com.proposito.model.AbstractModelDeletavel;
import com.proposito.model.usuario.Cargo;
import com.proposito.model.usuario.Usuario;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

/**
 * Entidade responsável por armazenar os diversos {@link Usuario}s participantes
 * de um {@link Projeto}.
 * 
 * @author kloss
 *
 */
@Entity(name = "ParticipacaoProjeto")
@Table(name = "participacao_projeto", indexes = { @Index(columnList = "hash") })
@Where(clause = "deletado = false")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ParticipacaoProjeto extends AbstractModelDeletavel {

	@Id
	@SequenceGenerator(name = "participacaoSequence", sequenceName = "participacao_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participacaoSequence")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`idProjeto`")
	private Projeto projeto;

	/**
	 * Colaborador que está sendo avaliado, independentemente do
	 * {@link TipoParticipanteProjeto}
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`idColaborador`")
	private Usuario colaborador;

	/**
	 * Hash para acesso único na plataforma
	 */
	@Column(unique = true)
	private String hash;

	/**
	 * Lista de inputs que um colaborador {@link Usuario} coloca em um
	 * {@link Projeto} de acordo com os {@link Recurso} e {@link Indicador}es
	 * envolvidos.
	 */
	@OneToMany(fetch = FetchType.LAZY, targetEntity = InputProjeto.class, cascade = CascadeType.ALL, mappedBy = "participante")
	private List<InputProjeto> inputs = new ArrayList<InputProjeto>();

	/**
	 * Cargo do {@link Usuario} colaborador no momento da inserção do registro. OBS
	 * deve ser atualizado no momento da inserção dos objetos filhos.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`idCargo`")
	private Cargo cargo;

	/**
	 * Observação da participação, caso necessária.
	 */
	@Column(columnDefinition = "TEXT")
	private String observacao;

	/**
	 * Dados parciais da participação para que nada seja perdido. Basicamente a
	 * lista com todos os {@link InputProjeto} em formato json OBS: essa coluna se
	 * torna OBSOLETA após a inserção definitiva dos inputs.
	 */
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb", name = "`partialData`")
	private String partialData;

	@Column(name = "`dataCriacao`", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataCriacao = OffsetDateTime.now();

	@Column(name = "`dataFim`", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataFim;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getColaborador() {
		return colaborador;
	}

	public void setColaborador(Usuario colaborador) {
		this.colaborador = colaborador;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<InputProjeto> getInputs() {
		return inputs;
	}

	public void setInputs(List<InputProjeto> inputs) {
		this.inputs = inputs;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPartialData() {
		return partialData;
	}

	public void setPartialData(String partialData) {
		this.partialData = partialData;
	}

	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public OffsetDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(OffsetDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public void addInput(final InputProjeto input) {
		inputs.add(input);
		input.setParticipante(this);
	}

}
