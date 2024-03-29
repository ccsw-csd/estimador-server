package com.ccsw.estimador.elementweight;

import java.util.List;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.elementweight.model.ElementWeightEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         ElementWeight
 *
 */
public interface ElementWeightService {

    List<ElementWeightEntity> findByEstimationId(Long id);

    List<ElementWeightEntity> findByEstimationCustomer(CustomerDto customer);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

    ElementWeightEntity get(Long id);

}
