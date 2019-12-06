package com.proposito.model.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.proposito.model.i18n.Idioma;

/**
 * Model que representa a tabela para armazenamento dos inputs relacionados a
 * {@link Recurso}s de um {@link Projeto}.
 * 
 * @author kloss
 *
 */
@Entity(name = "InputRecurso")
@DiscriminatorValue(value = "RECURSO")
public class InputRecurso extends InputProjeto {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`idIdioma`")
	private Idioma idioma;

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

}
