package com.capgemini.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         TaskDevelopmentHours
 *
 */
public interface TaskDevelopmentHoursService {

    List<TaskDevelopmentHoursEntity> findByEstimationId(Long id);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
