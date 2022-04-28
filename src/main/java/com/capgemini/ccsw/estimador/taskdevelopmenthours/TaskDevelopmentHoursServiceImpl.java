package com.capgemini.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         TaskDevelopmentHoursService
 *
 */
@Service
public class TaskDevelopmentHoursServiceImpl implements TaskDevelopmentHoursService {

    @Autowired
    TaskDevelopmentHoursRepository taskDevelopmentHoursRepository;

    @Override
    public List<TaskDevelopmentHoursEntity> findByEstimationId(Long id) {
        return this.taskDevelopmentHoursRepository.findByEstimationId(id);
    }
}
