package com.proposito.model.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.proposito.model.core.feature.Feature;

/**
 * Model que representa a tabela para armazenamento de uma configuração de um
 * projeto de {@link Competencia}.
 * 
 * @author kloss
 *
 */
@Entity(name = "ConfiguracaoCompetencia")
@DiscriminatorValue(value = "COMPETENCIA")
public class ConfiguracaoCompetencia extends ConfiguracaoProjeto {

	@Override
	public Feature getMainFeature() {
		// TODO Auto-generated method stub
		return Feature.Teste;
	}

}
