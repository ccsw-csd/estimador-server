package com.capgemini.ccsw.estimador.collaborator;

import java.util.List;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * TODO asolerpa This type ...
 *
 */
public interface CollaboratorService {

    List<CollaboratorEntity> findByEstimation(EstimationEntity estimation);

}
