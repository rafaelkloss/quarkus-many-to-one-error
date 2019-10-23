package com.proposito.model.core.evidencia.feedback;

import java.time.OffsetDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Entity(name = "Request")
@Table(name = "request")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 30)
@Cacheable
public abstract class Request extends AbstractModel {

	@Id
	@SequenceGenerator(name = "requestSequence", sequenceName = "request_feedback_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestSequence")
	private Integer id;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`idSolicitante`")
	private Usuario solicitante;

	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false, name = "status")
	private StatusSolicitacaoFeedback status = StatusSolicitacaoFeedback.SOLICITADO;

	@Column(name = "`dataCriacao`", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataCriacao = OffsetDateTime.now();

	/**
	 * Hash para acesso único na plataforma
	 */
	@Column(unique = true)
	private String hash;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public StatusSolicitacaoFeedback getStatus() {
		return status;
	}

	public void setStatus(StatusSolicitacaoFeedback status) {
		this.status = status;
	}

}
