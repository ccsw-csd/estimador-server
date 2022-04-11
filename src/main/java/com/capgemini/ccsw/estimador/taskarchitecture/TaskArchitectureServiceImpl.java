package com.capgemini.ccsw.estimador.taskarchitecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.estimation.EstimationService;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
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

    @Autowired
    EstimationService estimationService;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public List<TaskArchitectureEntity> findByEstimation(Long id) {
        return this.taskArchitectureRepository.findByEstimation(
                this.beanMapper.map(this.estimationService.getEstimation(id), EstimationEntity.class));
    }

}
