package com.capgemini.ccsw.estimador.estimationparameter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.estimation.EstimationService;
import com.capgemini.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         EstimationParameterService
 *
 */
@Service
public class EstimationParameterServiceImpl implements EstimationParameterService {

    @Autowired
    EstimationParameterRepository estimationParameterRepository;

    @Autowired
    EstimationService estimationService;

    @Override
    public List<EstimationParameterEntity> findParametersByEstimation(Long id) {

        return this.estimationParameterRepository.findByEstimation(this.estimationService.getEstimation(id));

    }

    @Override
    public List<EstimationParameterEntity> findParametersByEstimationCustomer(CustomerDto customer) {

        return findParametersByEstimation((this.estimationService.getLastEstimationByCustomer(customer).getId()));

    }

}