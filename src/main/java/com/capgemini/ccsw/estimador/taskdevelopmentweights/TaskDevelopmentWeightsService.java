package com.capgemini.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

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

}
