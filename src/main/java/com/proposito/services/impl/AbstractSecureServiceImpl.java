
package com.proposito.services.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.proposito.dto.AbstractDTO;
import com.proposito.model.AbstractModel;

public abstract class AbstractSecureServiceImpl<Model extends AbstractModel, DTO extends AbstractDTO>
		extends AbstractServiceImpl<Model> {

	/**
	 * Implementação de ordenação padrão
	 * 
	 * @param listagem
	 */
	protected abstract void sortList(final List<DTO> listagem);

	@SuppressWarnings("unchecked")
	protected Class<DTO> getDtoClass() {
		return (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}


}
