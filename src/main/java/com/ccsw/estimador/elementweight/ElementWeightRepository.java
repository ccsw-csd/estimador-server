package com.ccsw.estimador.elementweight;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.elementweight.model.ElementWeightEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla
 *         work_element_weights en base de datos
 *
 */
public interface ElementWeightRepository extends CrudRepository<ElementWeightEntity, Long> {

    @EntityGraph(attributePaths = { "estimation", "level" })
    List<ElementWeightEntity> findByEstimationId(Long estimationId);

}
