package com.proposito.exceptions;

/**
 * The abstract excetion for api. IMPORTANT: extends {@link RuntimeException}
 * because this: https://quarkus.io/guides/transaction-guide if the exception
 * instanceof {@link RuntimeException}, rollback the transaction !
 * 
 * @author kloss
 *
 */
public abstract class AbstractPROException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5609463894365445458L;

	protected String mensagem;

	protected String detalhes;

	protected AbstractPROException() {
	}

	protected AbstractPROException(Throwable originalException) {
		super(originalException);
	}

	/**
	 * Código de erro HTTP, normalmente 401 - Não autorizado 403 - Proibido 404 -
	 * Não encontrado 409 - Erro de negócio 500 - Erro não checado ou interno do
	 * servidor
	 * TODO colocar 422
	 * @return
	 */
	public abstract int getHttpErrorCode();

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

}
