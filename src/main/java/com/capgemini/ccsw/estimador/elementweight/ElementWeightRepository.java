package com.capgemini.ccsw.estimador.elementweight;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.elementweight.model.ElementWeightEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla
 *         work_element_weights en base de datos
 *
 */
public interface ElementWeightRepository extends CrudRepository<ElementWeightEntity, Long> {

    List<ElementWeightEntity> findByEstimation(EstimationEntity estimation);

}
