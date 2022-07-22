package com.capgemini.ccsw.estimador.distribution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.distribution.model.DistributionEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz SummaryService
 *
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    DistributionRepository distributionRepository;

    @Override
    public List<DistributionEntity> findByEstimationId(Long id) {

        return this.distributionRepository.findByEstimationId(id);
    }

}
