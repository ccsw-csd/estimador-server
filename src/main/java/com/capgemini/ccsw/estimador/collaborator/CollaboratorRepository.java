package com.capgemini.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla
 *         estimation_collaborators en base de datos
 *
 */
public interface CollaboratorRepository extends CrudRepository<CollaboratorEntity, Long> {

    List<CollaboratorEntity> findByEstimation(EstimationEntity estimation);

}
