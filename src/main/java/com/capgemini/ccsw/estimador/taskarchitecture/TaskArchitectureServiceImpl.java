package com.capgemini.ccsw.estimador.taskarchitecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         TaskArchitectureService
 *
 */
@Service
public class TaskArchitectureServiceImpl implements TaskArchitectureService {

    @Autowired
    TaskArchitectureRepository taskArchitectureRepository;

    @Override
    public List<TaskArchitectureEntity> findByEstimationId(Long id) {
        return this.taskArchitectureRepository.findByEstimationId(id);
    }

}
