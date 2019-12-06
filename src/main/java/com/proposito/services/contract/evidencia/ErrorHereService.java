package com.proposito.services.contract.evidencia;

import com.proposito.dto.evidencia.feedback.SolicitacaoFeedbackInternoDTO;

public interface ErrorHereService extends EvidenciaService {

	public String errorRequestHere(final SolicitacaoFeedbackInternoDTO solicitacaoDTO);

	public String errorProxy();

	public Integer createProject();

}
