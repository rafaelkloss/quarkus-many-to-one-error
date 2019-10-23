package com.proposito.exceptions;

import javax.ws.rs.core.Response;

public class PROCheckedException extends AbstractPROException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853754863992624969L;

	private boolean isBusinessException = false;

	public PROCheckedException(final String mensagem, final boolean isBusinessException) {
		this.mensagem = mensagem;
		this.isBusinessException = isBusinessException;
	}

	public PROCheckedException(final String mensagem, final String detalhes, final boolean isBusinessException) {
		this.mensagem = mensagem;
		this.detalhes = detalhes;
		this.isBusinessException = isBusinessException;
	}

	public PROCheckedException(final String mensagem, Throwable originalException, final boolean isBusinessException) {
		super(originalException);
		this.detalhes = originalException.getMessage();
		this.mensagem = mensagem;
		this.isBusinessException = isBusinessException;
	}

	@Override
	public int getHttpErrorCode() {
		// se uma Exception de negócio, retorna 409, conflito !
		return isBusinessException ? Response.Status.CONFLICT.getStatusCode()
				: Response.Status.NOT_FOUND.getStatusCode();
	}
}
