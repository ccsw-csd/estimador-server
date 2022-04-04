package com.capgemini.ccsw.estimador.estimationParameter;

import java.util.List;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.estimationParameter.model.EstimationParameterEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         EstimationParameter
 *
 */
public interface EstimationParameterService {

    List<EstimationParameterEntity> findParametersByEstimation(Long id);

    List<EstimationParameterEntity> findParametersByEstimationCustomer(CustomerDto customer);

}
