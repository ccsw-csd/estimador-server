package com.ccsw.estimador.consideration;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.consideration.model.ConsiderationEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla outscope en base
 *         de datos
 *
 */
public interface ConsiderationRepository extends CrudRepository<ConsiderationEntity, Long> {

    List<ConsiderationEntity> findByEstimationIdOrderByOrderAsc(Long estimationId);

}
