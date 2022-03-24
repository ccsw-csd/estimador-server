package com.capgemini.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz CollaboratorService
 *
 */
@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Override
    public List<CollaboratorEntity> findByEstimation(EstimationEntity estimation) {

        return this.collaboratorRepository.findByEstimation(estimation);

    }

}
