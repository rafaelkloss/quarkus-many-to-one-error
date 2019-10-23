package com.proposito.services.contract.evidencia;

import com.proposito.dto.evidencia.feedback.SolicitacaoFeedbackInternoDTO;
import com.proposito.model.core.evidencia.feedback.InternalRequest;
import com.proposito.model.usuario.Usuario;


public interface ErrorHereService extends EvidenciaService {

	public String errorRequestHere(final SolicitacaoFeedbackInternoDTO solicitacaoDTO);

}
