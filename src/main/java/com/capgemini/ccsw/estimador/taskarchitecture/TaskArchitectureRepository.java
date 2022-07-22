package com.capgemini.ccsw.estimador.taskarchitecture;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla task_architecture
 *         en base de datos
 *
 */
public interface TaskArchitectureRepository extends CrudRepository<TaskArchitectureEntity, Long> {

    List<TaskArchitectureEntity> findByEstimationIdOrderByOrderAsc(Long estimationId);

}
