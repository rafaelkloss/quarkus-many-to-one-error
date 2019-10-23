package com.proposito.dto.evidencia.feedback;

import com.proposito.dto.usuario.UsuarioDTO;

/**
 * Quando o evidenciador de um participante é interno ({@link UsuarioDTO})
 * 
 * @author kloss
 *
 */
public class SolicitacaoFeedbackInternoDTO extends SolicitacaoFeedbackDTO {

	/**
	 * Para quem está sendo solicitado esse feedback ?, ou seja, quem vai "dar" esse
	 * feedback ?
	 */
	private UsuarioDTO usuarioSolicitacao;

	public UsuarioDTO getUsuarioSolicitacao() {
		return usuarioSolicitacao;
	}

	public void setUsuarioSolicitacao(UsuarioDTO usuarioSolicitacao) {
		this.usuarioSolicitacao = usuarioSolicitacao;
	}

}
