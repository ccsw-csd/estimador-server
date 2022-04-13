package com.capgemini.ccsw.estimador.taskarchitecture;

import java.util.List;

import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         TaskArchitecture
 *
 */
public interface TaskArchitectureService {

    List<TaskArchitectureEntity> findByEstimationId(Long id);

}
