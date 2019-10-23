package com.proposito.model.core.evidencia.feedback;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.proposito.model.usuario.Usuario;

@Entity(name = "InternalRequest")
@DiscriminatorValue(value = "INTERN")
public class InternalRequest extends Request {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`idUsuarioSolicitacao`")
	private Usuario usuarioSolicitacao;

	public Usuario getUsuarioSolicitacao() {
		return usuarioSolicitacao;
	}

	public void setUsuarioSolicitacao(Usuario usuarioSolicitacao) {
		this.usuarioSolicitacao = usuarioSolicitacao;
	}

}
