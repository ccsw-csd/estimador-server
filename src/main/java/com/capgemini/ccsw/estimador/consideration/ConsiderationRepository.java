package com.capgemini.ccsw.estimador.consideration;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.consideration.model.ConsiderationEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla outscope en base
 *         de datos
 *
 */
public interface ConsiderationRepository extends CrudRepository<ConsiderationEntity, Long> {

    List<ConsiderationEntity> findByEstimation(EstimationEntity estimation);

}
