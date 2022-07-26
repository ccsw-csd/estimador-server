package com.ccsw.estimador.distribution;

import java.util.List;

import com.ccsw.estimador.distribution.model.DistributionEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad Summary
 *
 */
public interface DistributionService {

    List<DistributionEntity> findByEstimationId(Long id);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
