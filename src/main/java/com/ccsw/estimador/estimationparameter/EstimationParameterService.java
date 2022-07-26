package com.ccsw.estimador.estimationparameter;

import java.util.List;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.estimationparameter.model.EstimationParameterEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         EstimationParameter
 *
 */
public interface EstimationParameterService {

    List<EstimationParameterEntity> findParametersByEstimationId(Long id);

    List<EstimationParameterEntity> findParametersByEstimationCustomer(CustomerDto customer);

    void save(EstimationParameterEntity estimationParameter);

}
