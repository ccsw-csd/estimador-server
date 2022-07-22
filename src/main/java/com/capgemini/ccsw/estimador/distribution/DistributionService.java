package com.capgemini.ccsw.estimador.distribution;

import java.util.List;

import com.capgemini.ccsw.estimador.distribution.model.DistributionEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad Summary
 *
 */
public interface DistributionService {

    List<DistributionEntity> findByEstimationId(Long id);

}
