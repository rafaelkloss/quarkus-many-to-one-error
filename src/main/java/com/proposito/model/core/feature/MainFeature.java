package com.proposito.model.core.feature;

import com.proposito.model.AbstractModel;

/**
 * Interface que deve ser implementada por todos os modelos concretos que
 * representam uma {@link Feature} ou em projetos.
 * 
 * @author kloss
 *
 */
public interface MainFeature {

	/**
	 * Retorna a {@link Feature} implementada no Modelo (? extends
	 * {@link AbstractModel}) no caso dos Recursos <br>
	 * No caso dos projetos, retorna que tipo de feature está sendo utilizada no
	 * projeto em questão.
	 * 
	 * @return
	 */
	public Feature getMainFeature();
}
