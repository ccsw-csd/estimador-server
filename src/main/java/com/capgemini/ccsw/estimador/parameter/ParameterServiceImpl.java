package com.capgemini.ccsw.estimador.parameter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.estimationparameter.EstimationParameterService;
import com.capgemini.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;
import com.capgemini.ccsw.estimador.parameter.model.ParameterEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ParameterService
 *
 */
@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    EstimationParameterService estimationParameterService;

    @Autowired
    ParameterRepository parameterRepository;

    @Override
    public List<ParameterEntity> findParametersByEstimationId(Long id) {
        List<ParameterEntity> parameters = new ArrayList();

        List<EstimationParameterEntity> list = this.estimationParameterService.findParametersByEstimationId(id);

        list.forEach(element -> {
            parameters.add(element.getParameter());
        });

        return parameters;
    }

    @Override
    public List<ParameterEntity> findParametersByEstimationCustomer(CustomerDto customer) {

        List<ParameterEntity> parameters = new ArrayList();

        List<EstimationParameterEntity> list = this.estimationParameterService
                .findParametersByEstimationCustomer(customer);

        list.forEach(element -> {
            parameters.add(element.getParameter());
        });

        return parameters;
    }

    @Override
    public List<ParameterEntity> findAll() {
        return (List<ParameterEntity>) parameterRepository.findAll();
    }

}
