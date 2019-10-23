package com.proposito.exceptions;

import javax.ws.rs.core.Response;

public class PROSecurityException extends AbstractPROException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4952637441005181518L;

	public PROSecurityException(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public int getHttpErrorCode() {
		return Response.Status.UNAUTHORIZED.getStatusCode();
	}

}
