package com.proposito.dto.contract;

import org.modelmapper.ModelMapper;

/**
 * Interface para DTOs que precisam de operações específicas ao atualizar
 * 
 * @author kloss
 *
 */
public interface CustomToModelUpdateMapper<Model> {

	/**
	 * o que fazer antes do update ?
	 * 
	 * @param modelMapper
	 */
	public abstract void beforeUpdate(final ModelMapper modelMapper, final Model model);

}
