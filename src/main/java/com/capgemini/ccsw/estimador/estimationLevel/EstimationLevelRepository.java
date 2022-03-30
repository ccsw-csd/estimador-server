package com.capgemini.ccsw.estimador.estimationLevel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.estimationLevel.model.EstimationLevelEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla estimation_level
 *         en base de datos
 *
 */
public interface EstimationLevelRepository extends CrudRepository<EstimationLevelEntity, Long> {

    @Override
    List<EstimationLevelEntity> findAll();

}
