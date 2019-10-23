package com.proposito.dto.contract;

import com.proposito.dto.AbstractDTO;
import com.proposito.model.AbstractModel;

/**
 * Interface utilizada para mapear de objetos para dtos atributos que necessitam
 * de atenção específica.
 * 
 * @author kloss
 *
 * @param <DTO>   ? extends {@link AbstractDTO}
 * @param <Model> ? extends {@link AbstractModel}
 */
public interface CustomToDTOMapper<DTO extends AbstractDTO, Model extends AbstractModel> {

	/**
	 * Mapeia os atributos específicos de acordo com a situação de um model para um
	 * dto
	 * 
	 * @param dto
	 * @param model
	 */
	public void map(final DTO dto, Model model);
}
