package com.proposito.model.project;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Model que representa a tabela para armazenamento dos inputs relacionados a
 * {@link Indicador}s de um {@link Projeto}.
 * 
 * @author kloss
 *
 */
@Entity(name = "InputIndicador")
@DiscriminatorValue(value = "INDICADOR")
public class InputIndicador extends InputProjeto {

	@Column(name = "`indicador`")
	private String indicador;

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

}
