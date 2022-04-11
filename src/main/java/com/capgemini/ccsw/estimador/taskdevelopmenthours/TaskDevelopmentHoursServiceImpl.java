package com.capgemini.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.estimation.EstimationService;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
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

    @Autowired
    EstimationService estimationService;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public List<TaskDevelopmentHoursEntity> findByEstimation(Long id) {
        return this.taskDevelopmentHoursRepository.findByEstimation(
                this.beanMapper.map(this.estimationService.getEstimation(id), EstimationEntity.class));
    }
}
