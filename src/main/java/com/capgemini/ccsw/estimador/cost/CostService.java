package com.capgemini.ccsw.estimador.cost;

import com.capgemini.ccsw.estimador.cost.model.CostEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

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
