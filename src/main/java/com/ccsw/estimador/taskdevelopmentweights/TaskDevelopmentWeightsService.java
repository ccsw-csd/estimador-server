package com.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsEntity;

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
