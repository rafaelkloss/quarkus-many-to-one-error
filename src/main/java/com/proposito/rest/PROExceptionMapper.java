package com.proposito.rest;

import javax.json.Json;
import javax.persistence.PersistenceException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proposito.exceptions.AbstractPROException;
import com.proposito.exceptions.PROCheckedException;
import com.proposito.exceptions.PROSecurityException;
import com.proposito.exceptions.PROUncheckedException;

/**
 * Mapper geral de exceções da api: <br>
 * <p>
 * Se erro de segurança, lançar uma {@link PROSecurityException}
 * </p>
 * <p>
 * Se erro de negócio, lançar uma {@link PROCheckedException} com
 * isBusinessException = true
 * </p>
 * <p>
 * Se erro de não encontrar registro, lançar uma {@link PROCheckedException} com
 * isBusinessException = false
 * </p>
 * <p>
 * Se erro desconhecido, lançar uma {@link PROUncheckedException}
 * </p>
 * 
 * @author kloss
 *
 */
public class PROExceptionMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger("MappedExceptions");

	@Provider
	public static class ErrorMapper implements ExceptionMapper<Exception> {

		@Override
		public Response toResponse(Exception exception) {
			int code = 500;
			String msgOriginal = exception.getMessage() != null ? exception.getMessage() : exception.toString();
			String msg = exception.getMessage() != null ? exception.getMessage() : exception.toString();
			if (exception instanceof WebApplicationException) {
				code = ((WebApplicationException) exception).getResponse().getStatus();
				LOGGER.error(msg, exception);
			} else if (exception instanceof AbstractPROException) {
				final AbstractPROException proSec = (AbstractPROException) exception;
				msg = proSec.getMensagem();
				code = proSec.getHttpErrorCode();
				LOGGER.warn(msg, exception);
			} else if (exception instanceof PersistenceException) {
				final PersistenceException perEx = (PersistenceException) exception;
				msg = perEx.getCause().getCause().getMessage();
				if (msg.contains("Detail:")) {
					msg = "Error: " + msg.split("Detail:")[1];
				}
				// because here is a business rule error
				code = 409;
				LOGGER.error(msg, exception);
			} else {
				LOGGER.error(msg, exception);
			}

			return Response.status(code).entity(Json.createObjectBuilder().add("error", msg)
					.add("originalException", msgOriginal).add("code", code).build()).build();
		}

	}
}
