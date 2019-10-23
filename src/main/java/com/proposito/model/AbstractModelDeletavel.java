package com.proposito.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;

/**
 * Entidade que representa objetos que podem ser deletados lógicamente. usar
 * where deletado = false ou Where = deletado = false
 * 
 * @author kloss
 *
 */
@MappedSuperclass
@Where(clause = "deletado = false")
public abstract class AbstractModelDeletavel extends AbstractModel {

	@Column(nullable = false)
	private Boolean deletado = false;

	public Boolean getDeletado() {
		return deletado;
	}

	public void setDeletado(Boolean deletado) {
		this.deletado = deletado;
	}

	/**
	 * Seta o objeto em questão para deletado logicamente. <br>
	 * IMPORTANTE: não persiste no banco de dados, isso precisa ser feito
	 * posteriormente.
	 */
	public void delete() {
		this.deletado = Boolean.TRUE;
	}

	/**
	 * Seta o objeto em questão para NÃO deletado logicamente. <br>
	 * IMPORTANTE: não persiste no banco de dados, isso precisa ser feito
	 * posteriormente.
	 */
	public void unDelete() {
		this.deletado = Boolean.FALSE;
	}

}
