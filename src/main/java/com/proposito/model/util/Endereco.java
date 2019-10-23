package com.proposito.model.util;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.proposito.model.AbstractEmbeddable;

@Embeddable
public class Endereco extends AbstractEmbeddable {

	@Column(length = 200, nullable = false, name = "`enderecoPadraoGoogle`")
	private String enderecoPadraoGoogle;

	@Column(length = 255)
	private String complemento;

	public String getEnderecoPadraoGoogle() {
		return enderecoPadraoGoogle;
	}

	public void setEnderecoPadraoGoogle(String enderecoPadraoGoogle) {
		this.enderecoPadraoGoogle = enderecoPadraoGoogle;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
