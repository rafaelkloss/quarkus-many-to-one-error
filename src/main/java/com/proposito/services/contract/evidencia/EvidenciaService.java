package com.proposito.services.contract.evidencia;

import javax.persistence.OneToOne;

import com.proposito.model.core.evidencia.Evidencia;
import com.proposito.services.contract.AbstractServiceInterface;

/**
 * Interfaçe para lidar com {@link Evidencia} seja {@link Feedback} ou
 * {@link OneToOne}
 * 
 * @author kloss
 *
 */
public interface EvidenciaService extends AbstractServiceInterface {

}
