package com.ccsw.estimador.cost;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.cost.model.CostEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla cost en base de
 *         datos
 *
 */
public interface CostRepository extends CrudRepository<CostEntity, Long> {

    CostEntity getByEstimationId(Long estimationId);

}
