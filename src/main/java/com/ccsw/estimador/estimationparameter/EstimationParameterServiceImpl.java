package com.ccsw.estimador.estimationparameter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.estimation.EstimationService;
import com.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;

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
    public List<EstimationParameterEntity> findParametersByEstimationId(Long id) {

        return this.estimationParameterRepository.findByEstimationId(id);

    }

    @Override
    public List<EstimationParameterEntity> findParametersByEstimationCustomer(CustomerDto customer) {

        return findParametersByEstimationId((this.estimationService.getLastEstimationByCustomer(customer).getId()));

    }

    @Override
    public void save(EstimationParameterEntity estimationParameter) {
        this.estimationParameterRepository.save(estimationParameter);

    }

}
