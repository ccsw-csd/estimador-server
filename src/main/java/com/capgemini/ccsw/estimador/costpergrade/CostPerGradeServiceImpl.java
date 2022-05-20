package com.capgemini.ccsw.estimador.costpergrade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.costpergrade.model.CostPerGradeEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz CostPerGradeService
 *
 */
@Service
public class CostPerGradeServiceImpl implements CostPerGradeService {

    @Autowired
    CostPerGradeRepository costPerGradeRepository;

    @Override
    public List<CostPerGradeEntity> findByEstimationId(Long estimationId) {
        return this.costPerGradeRepository.findByEstimationId(estimationId);
    }

}
