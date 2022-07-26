package com.ccsw.estimador.distribution;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.distribution.model.DistributionEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla summary en base
 *         de datos
 *
 */
public interface DistributionRepository extends CrudRepository<DistributionEntity, Long> {

    List<DistributionEntity> findByEstimationId(Long estimationId);

}