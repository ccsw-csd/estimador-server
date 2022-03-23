package com.capgemini.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * TODO asolerpa This type ...
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
