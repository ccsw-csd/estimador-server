package com.capgemini.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         TaskDevelopmentWeightsService
 *
 */
@Service
public class TaskDevelopmentWeightsServiceImpl implements TaskDevelopmentWeightsService {

    @Autowired
    TaskDevelopmentWeightsRepository taskDevelopmentWeightsRepository;

    @Override
    public List<TaskDevelopmentWeightsEntity> findByEstimationId(Long id) {
        return this.taskDevelopmentWeightsRepository.findByEstimationId(id);
    }

}
