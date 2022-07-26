package com.ccsw.estimador.cost;

import com.ccsw.estimador.cost.model.CostEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         CostPerGrade
 *
 */
public interface CostService {

    CostEntity getByEstimationId(Long estimationId);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
