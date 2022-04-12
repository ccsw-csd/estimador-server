package com.capgemini.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla task_hour en base
 *         de datos
 *
 */
public interface TaskDevelopmentHoursRepository extends CrudRepository<TaskDevelopmentHoursEntity, Long> {

    List<TaskDevelopmentHoursEntity> findByEstimationId(Long estimationId);

}
