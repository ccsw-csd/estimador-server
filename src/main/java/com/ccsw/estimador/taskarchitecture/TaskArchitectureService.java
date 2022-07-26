package com.ccsw.estimador.taskarchitecture;

import java.util.List;

import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.taskarchitecture.model.TaskArchitectureEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         TaskArchitecture
 *
 */
public interface TaskArchitectureService {

    List<TaskArchitectureEntity> findByEstimationId(Long id);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
