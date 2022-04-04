package com.capgemini.ccsw.estimador.elementWeight;

import java.util.List;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.elementWeight.model.ElementWeightEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         ElementWeight
 *
 */
public interface ElementWeightService {

    List<ElementWeightEntity> findByEstimation(Long id);

    List<ElementWeightEntity> findByEstimationCustomer(CustomerDto customer);

}
