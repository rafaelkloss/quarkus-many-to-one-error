package com.proposito.model.cliente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@DiscriminatorValue(value = "FILIAL")
@Entity(name = "Filial")
public class Filial extends Cliente {

	@ManyToOne
	@JoinColumn(name = "`idMatriz`")
	private Matriz matriz;

	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

}
