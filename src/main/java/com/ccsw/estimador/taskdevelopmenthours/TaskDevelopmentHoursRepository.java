package com.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla task_hour en base
 *         de datos
 *
 */
public interface TaskDevelopmentHoursRepository extends CrudRepository<TaskDevelopmentHoursEntity, Long> {

    List<TaskDevelopmentHoursEntity> findByEstimationIdOrderByOrderAsc(Long estimationId);

}
