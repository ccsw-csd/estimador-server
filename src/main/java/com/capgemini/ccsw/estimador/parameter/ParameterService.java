package com.capgemini.ccsw.estimador.parameter;

import java.util.List;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.parameter.model.ParameterEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         Parameter
 *
 */
public interface ParameterService {

    List<ParameterEntity> findParametersByEstimation(Long id);

    List<ParameterEntity> findParametersByEstimationCustomer(CustomerDto customer);

    List<ParameterEntity> findAll();
}
