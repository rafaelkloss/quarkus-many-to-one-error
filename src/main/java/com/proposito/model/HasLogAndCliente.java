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
public interface HasLogAndCliente {

	public LogRegistro getLog();

	public Cliente getCliente();

	public void setCliente(final Cliente cliente);
	
	public Integer getId();
}
