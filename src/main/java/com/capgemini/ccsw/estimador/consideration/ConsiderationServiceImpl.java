package com.capgemini.ccsw.estimador.consideration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.consideration.model.ConsiderationEntity;
import com.capgemini.ccsw.estimador.estimation.EstimationService;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ConsiderationService
 *
 */
@Service
public class ConsiderationServiceImpl implements ConsiderationService {

    @Autowired
    ConsiderationRepository considerationRepository;

    @Autowired
    EstimationService estimationService;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public List<ConsiderationEntity> findByEstimation(Long id) {
        return this.considerationRepository.findByEstimation(
                this.beanMapper.map(this.estimationService.getEstimation(id), EstimationEntity.class));
    }

}
