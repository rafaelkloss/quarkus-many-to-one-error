package com.proposito.model.cliente;

/**
 * Status do {@link Cliente}, que deve ser considerado na autenticação e que
 * pode ser:<br>
 * Ativo: ok, sem problemas;<br>
 * Inativo: inativo por um período de tempo;<br>
 * Cancelado: cancelado, não vai mais ser utilizado, informar o motivo ao
 * cancelar;
 * 
 * @author kloss
 *
 */
public enum StatusCliente {
	ATIVO("Ativo"), CANCELADO("Cancelado"), INATIVO("Inativo");

	private final String descricao;

	private StatusCliente(final String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
