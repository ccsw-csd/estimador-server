package com.capgemini.ccsw.estimador.summary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.summary.model.SummaryEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla summary en base
 *         de datos
 *
 */
public interface SummaryRepository extends CrudRepository<SummaryEntity, Long> {

    List<SummaryEntity> findByEstimationId(Long estimationId);

}