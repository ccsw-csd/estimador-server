package com.capgemini.ccsw.estimador.costpergrade;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.costpergrade.model.CostPerGradeEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla cost en base de
 *         datos
 *
 */
public interface CostPerGradeRepository extends CrudRepository<CostPerGradeEntity, Long> {

    List<CostPerGradeEntity> findByEstimationId(Long estimationId);

}
