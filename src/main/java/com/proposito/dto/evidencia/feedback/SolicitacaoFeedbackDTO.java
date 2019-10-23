package com.proposito.dto.evidencia.feedback;

import java.time.OffsetDateTime;

import com.proposito.dto.AbstractDTO;
import com.proposito.dto.usuario.UsuarioDTO;

/**
 * Entidade responsável por trafegar as solicitações de feedback.
 * 
 * @author kloss
 *
 */
public abstract class SolicitacaoFeedbackDTO extends AbstractDTO {

	private Integer id;

	private String descricao;

	private UsuarioDTO solicitante;

	private OffsetDateTime dataCriacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDTO getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(UsuarioDTO solicitante) {
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

}
