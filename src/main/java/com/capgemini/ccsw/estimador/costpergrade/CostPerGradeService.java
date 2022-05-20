package com.capgemini.ccsw.estimador.costpergrade;

import java.util.List;

import com.capgemini.ccsw.estimador.costpergrade.model.CostPerGradeEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         CostPerGrade
 *
 */
public interface CostPerGradeService {

    List<CostPerGradeEntity> findByEstimationId(Long estimationId);

}
