package com.capgemini.ccsw.estimador.elementweight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.elementweight.model.ElementWeightEntity;
import com.capgemini.ccsw.estimador.estimation.EstimationService;

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

    @Override
    public List<ElementWeightEntity> findByEstimation(Long id) {

        return this.elementWeightRepository.findByEstimationId(id);
    }

    @Override
    public List<ElementWeightEntity> findByEstimationCustomer(CustomerDto customer) {

        return this.elementWeightRepository
                .findByEstimationId(this.estimationService.getLastEstimationByCustomer(customer).getId());

    }

}
