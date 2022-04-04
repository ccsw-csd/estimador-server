package com.capgemini.ccsw.estimador.elementWeight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.elementWeight.model.ElementWeightEntity;
import com.capgemini.ccsw.estimador.estimation.EstimationService;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ElementWeightService
 *
 */
@Service
public class ElementWeightServiceImpl implements ElementWeightService {

    @Autowired
    ElementWeightRepository elementWeightRepository;

    @Autowired
    EstimationService estimationService;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public List<ElementWeightEntity> findByEstimation(Long id) {

        return this.elementWeightRepository.findByEstimation(
                this.beanMapper.map(this.estimationService.getEstimation(id), EstimationEntity.class));
    }

    @Override
    public List<ElementWeightEntity> findByEstimationCustomer(CustomerDto customer) {

        return this.elementWeightRepository
                .findByEstimation(this.estimationService.getLastEstimationByCustomer(customer));

    }

}
