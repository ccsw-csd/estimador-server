package com.capgemini.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         TaskDevelopmentWeights
 *
 */
public interface TaskDevelopmentWeightsService {

    List<TaskDevelopmentWeightsEntity> findByEstimationId(Long id);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
