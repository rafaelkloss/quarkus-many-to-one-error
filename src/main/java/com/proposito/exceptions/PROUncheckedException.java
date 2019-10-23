package com.proposito.exceptions;

import javax.ws.rs.core.Response;

public class PROUncheckedException extends AbstractPROException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853754863992624969L;

	public PROUncheckedException(final String mensagem) {
		this.mensagem = mensagem;
	}

	public PROUncheckedException(final String mensagem, final String detalhes) {
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public PROUncheckedException(final String mensagem, Throwable originalException) {
		super(originalException);
		this.detalhes = originalException.getMessage();
		this.mensagem = mensagem;
	}

	@Override
	public int getHttpErrorCode() {
		return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
	}
}
