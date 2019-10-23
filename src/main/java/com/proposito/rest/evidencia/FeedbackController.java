package com.proposito.rest.evidencia;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.proposito.dto.evidencia.feedback.SolicitacaoFeedbackInternoDTO;
import com.proposito.rest.AbstractRestController;
import com.proposito.services.contract.evidencia.ErrorHereService;

/**
 * Controller para lidar com {@link Feedback}s.
 * 
 * @author kloss
 *
 */
@Path("feedback")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackController extends AbstractRestController {

	@Inject
	ErrorHereService feedbackService;

	@POST
	@Path("solicitar/interno")
	@Transactional
	public Response solicitarFeedbackInterno(@Valid SolicitacaoFeedbackInternoDTO solicitacaoDTO) {
		final String nickUsuarioSolicitado = feedbackService.errorRequestHere(solicitacaoDTO);
		return Response.ok("success" + nickUsuarioSolicitado).status(201).build();
	}

}
