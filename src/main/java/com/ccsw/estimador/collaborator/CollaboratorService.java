package com.ccsw.estimador.collaborator;

import java.util.List;

import com.ccsw.estimador.collaborator.model.CollaboratorEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         Collaborator
 *
 */
public interface CollaboratorService {

    List<CollaboratorEntity> findByEstimationId(Long estimationId);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
