package com.ccsw.estimador.estimationlevel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.estimationlevel.model.EstimationLevelEntity;

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
