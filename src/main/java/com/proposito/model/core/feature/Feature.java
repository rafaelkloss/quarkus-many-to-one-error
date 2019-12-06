package com.proposito.model.core.feature;

import java.util.ArrayList;
import java.util.List;

public enum Feature {
	Teste("teste", null, false, false, false, false);

	private final String descricao;

	private final Feature featureMae;

	private final Boolean habilitavelPorCargo;

	private final Boolean habilitavelPorUsuario;

	private final Boolean habilitavelPorSquad;

	private final Boolean habilitavelPorDepartamento;

	private Feature(String descricao, Feature featureMae, Boolean habilitavelPorCargo, Boolean habilitavelPorUsuario,
			Boolean habilitavelPorSquad, Boolean habilitavelPorDepartamento) {
		this.descricao = descricao;
		this.featureMae = featureMae;
		this.habilitavelPorCargo = habilitavelPorCargo;
		this.habilitavelPorUsuario = habilitavelPorUsuario;
		this.habilitavelPorSquad = habilitavelPorSquad;
		this.habilitavelPorDepartamento = habilitavelPorDepartamento;
	}

	public final String getDescricao() {
		return this.descricao;
	}

	public final Feature getFeatureMae() {
		return this.featureMae;
	}

	public Boolean getHabilitavelPorCargo() {
		return habilitavelPorCargo;
	}

	public Boolean getHabilitavelPorUsuario() {
		return habilitavelPorUsuario;
	}

	public Boolean getHabilitavelPorSquad() {
		return habilitavelPorSquad;
	}

	public Boolean getHabilitavelPorDepartamento() {
		return habilitavelPorDepartamento;
	}

	public static final List<Feature> getFilhos(final Feature feature) {
		final List<Feature> retorno = new ArrayList<Feature>();
		for (Feature feat : Feature.values()) {
			if (feat.getFeatureMae().equals(feature)) {
				retorno.add(feat);
			}
		}
		return retorno;
	}

}
