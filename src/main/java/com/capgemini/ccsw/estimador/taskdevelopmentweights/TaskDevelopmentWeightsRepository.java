package com.capgemini.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla task_weight en
 *         base de datos
 *
 */
public interface TaskDevelopmentWeightsRepository extends CrudRepository<TaskDevelopmentWeightsEntity, Long> {

    List<TaskDevelopmentWeightsEntity> findByEstimationIdOrderByOrderAsc(Long estimationId);

}
