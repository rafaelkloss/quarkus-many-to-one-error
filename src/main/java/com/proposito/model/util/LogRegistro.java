package com.proposito.model.util;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import com.proposito.model.AbstractEmbeddable;
import com.proposito.model.usuario.Usuario;

@Embeddable
public class LogRegistro extends AbstractEmbeddable {

	/**
	 * Usado apenas para garantir que deve-se forçar ter um usuário para criação ou
	 * atualização, no entanto, transiente
	 */
	@Transient
	private Boolean forceUsuario = false;

	@Column(name = "`dataCriacao`", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataCriacao;

	@Column(name = "`dataAtualizacao`", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private OffsetDateTime dataAtualizacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`idUsuarioCriacao`")
	private Usuario usuarioCriacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`idUsuarioAtualizacao`")
	private Usuario usuarioAtualizacao;

	public LogRegistro() {
	}

	public LogRegistro(Boolean forceUsuario) {
		this.forceUsuario = forceUsuario;
	}

	@PrePersist
	public void prePersist() {
		this.dataCriacao = OffsetDateTime.now();
		if (null == this.usuarioCriacao && forceUsuario) {
			throw new UnsupportedOperationException("Usuário criador é obrigatório ao persistir um objeto com log");
		}
	}

	@PreUpdate
	public void preUpdate() {
		this.dataAtualizacao = OffsetDateTime.now();
		if (null == this.usuarioAtualizacao && forceUsuario) {
			throw new UnsupportedOperationException("Usuário atualizador é obrigatório ao atualizar um objeto com log");
		}
	}

	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public OffsetDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Usuario getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(Usuario usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public Usuario getUsuarioAtualizacao() {
		return usuarioAtualizacao;
	}

	public void setUsuarioAtualizacao(Usuario usuarioAtualizacao) {
		this.usuarioAtualizacao = usuarioAtualizacao;
	}

}
