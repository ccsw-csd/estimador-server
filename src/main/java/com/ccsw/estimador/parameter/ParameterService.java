package com.ccsw.estimador.parameter;

import java.util.List;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.parameter.model.ParameterEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         Parameter
 *
 */
public interface ParameterService {

    List<ParameterEntity> findParametersByEstimationId(Long id);

    List<ParameterEntity> findParametersByEstimationCustomer(CustomerDto customer);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);
}
