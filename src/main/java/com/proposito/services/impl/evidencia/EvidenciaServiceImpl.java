package com.proposito.services.impl.evidencia;

import java.util.List;

import javax.inject.Inject;

import com.proposito.dao.contract.evidencia.EvidenciaDAO;
import com.proposito.services.contract.evidencia.EvidenciaService;
import com.proposito.services.impl.AbstractSecureServiceImpl;

/**
 * Classe que implementa os serviços {@link EvidenciaService}
 * 
 * @author kloss
 *
 */
public abstract class EvidenciaServiceImpl extends AbstractSecureServiceImpl implements EvidenciaService {

	@Inject
	EvidenciaDAO evidenciaDAO;

	@Override
	protected void sortList(List listagem) {
		// TODO Auto-generated method stub

	}

}
