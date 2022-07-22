package com.capgemini.ccsw.estimador.cost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.cost.model.CostEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz CostService
 *
 */
@Service
public class CostServiceImpl implements CostService {

    @Autowired
    CostRepository costRepository;

    @Override
    public CostEntity getByEstimationId(Long estimationId) {
        return this.costRepository.getByEstimationId(estimationId);
    }

}
