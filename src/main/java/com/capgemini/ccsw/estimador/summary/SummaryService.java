package com.capgemini.ccsw.estimador.summary;

import java.util.List;

import com.capgemini.ccsw.estimador.summary.model.SummaryEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad Summary
 *
 */
public interface SummaryService {

    List<SummaryEntity> findByEstimationId(Long id);

}
