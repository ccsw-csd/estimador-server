package com.capgemini.ccsw.estimador.cost;

import com.capgemini.ccsw.estimador.cost.model.CostEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         CostPerGrade
 *
 */
public interface CostService {

    CostEntity getByEstimationId(Long estimationId);

}
