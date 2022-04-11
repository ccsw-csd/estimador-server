package com.capgemini.ccsw.estimador.estimationparameter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla
 *         estimation_parameters en base de datos
 *
 */
public interface EstimationParameterRepository extends CrudRepository<EstimationParameterEntity, Long> {

    List<EstimationParameterEntity> findByEstimation(EstimationEntity estimation);
}
