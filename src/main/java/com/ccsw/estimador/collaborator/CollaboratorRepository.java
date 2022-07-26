package com.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.collaborator.model.CollaboratorEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla
 *         estimation_collaborators en base de datos
 *
 */
public interface CollaboratorRepository extends CrudRepository<CollaboratorEntity, Long> {

    List<CollaboratorEntity> findByEstimationId(Long id);

}
