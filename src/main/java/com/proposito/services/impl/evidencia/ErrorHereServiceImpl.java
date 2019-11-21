
package com.proposito.services.impl.evidencia;

import javax.enterprise.context.RequestScoped;

import org.apache.commons.codec.digest.DigestUtils;

import com.proposito.dto.evidencia.feedback.SolicitacaoFeedbackInternoDTO;
import com.proposito.model.cliente.Matriz;
import com.proposito.model.core.evidencia.feedback.InternalRequest;
import com.proposito.model.usuario.Usuario;
import com.proposito.services.contract.evidencia.ErrorHereService;

@RequestScoped
public class ErrorHereServiceImpl extends EvidenciaServiceImpl implements ErrorHereService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String errorRequestHere(SolicitacaoFeedbackInternoDTO solicitacaoDTO) {
		// fake logged user
		final Usuario usuario = (Usuario) evidenciaDAO.getById(Usuario.class, 2);
		Matriz company;
		final Matriz matriz = usuario.getMatriz();
		company = matriz;
		final InternalRequest solicitacao = new InternalRequest();
		solicitacao.setDescricao(solicitacaoDTO.getDescricao());
		solicitacao.setSolicitante(usuario);
		final Usuario usuarioSolicitacao = (Usuario) evidenciaDAO.getById(Usuario.class,
				solicitacaoDTO.getUsuarioSolicitacao().getId());
		solicitacao.setUsuarioSolicitacao(usuarioSolicitacao);
		final InternalRequest solicitacaoPersistida = (InternalRequest) evidenciaDAO
				.persist(solicitacao);
		solicitacaoPersistida.setHash(DigestUtils.sha256Hex(solicitacaoPersistida.getId().toString()));
		evidenciaDAO.persist(solicitacaoPersistida);
		return usuarioSolicitacao.getAdaptedNick();
	}

}
