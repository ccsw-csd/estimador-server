package com.capgemini.ccsw.estimador.estimationparameter;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla
 *         estimation_parameters en base de datos
 *
 */
public interface EstimationParameterRepository extends CrudRepository<EstimationParameterEntity, Long> {

    @EntityGraph(attributePaths = { "estimation", "parameter", "parameter.block" })
    List<EstimationParameterEntity> findByEstimationId(Long estimationId);

}
