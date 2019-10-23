package com.proposito.model;

import com.proposito.model.cliente.Cliente;
import com.proposito.model.util.LogRegistro;

/**
 * Interface utilizada para abstrair funcionalidades de cruds básicos do sistema
 * que possuam {@link Cliente} e {@link LogRegistro}
 * 
 * @author kloss
 *
 */
public interface HasToggleAtivo {

	public Boolean getAtivo();

	public void setAtivo(Boolean ativo);
}
