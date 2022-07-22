package com.capgemini.ccsw.estimador.consideration;

import java.util.List;

import com.capgemini.ccsw.estimador.consideration.model.ConsiderationEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         Consideration
 *
 */
public interface ConsiderationService {

    List<ConsiderationEntity> findByEstimationId(Long id);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
