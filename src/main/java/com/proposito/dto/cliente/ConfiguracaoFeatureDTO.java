package com.proposito.dto.cliente;

import java.util.HashSet;
import java.util.Set;

import com.proposito.dto.AbstractDTO;
import com.proposito.model.core.feature.Feature;

/**
 * DTo para transferir informações em relação as configuraçÕes de um cliente
 * 
 * @author kloss
 *
 */
public class ConfiguracaoFeatureDTO extends AbstractDTO {
	
	private Feature feature;

	private Boolean habilitada;

	private String nomeCustomizado;

	private Set<ConfiguracaoFeatureDTO> filhos = new HashSet<ConfiguracaoFeatureDTO>();

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Boolean ativo) {
		this.habilitada = ativo;
	}

	public String getNomeCustomizado() {
		return nomeCustomizado;
	}

	public void setNomeCustomizado(String nomeCustomizado) {
		this.nomeCustomizado = nomeCustomizado;
	}

	public Set<ConfiguracaoFeatureDTO> getFilhos() {
		return filhos;
	}

	public void addFilho(ConfiguracaoFeatureDTO filho) {
		this.filhos.add(filho);
	}

}
