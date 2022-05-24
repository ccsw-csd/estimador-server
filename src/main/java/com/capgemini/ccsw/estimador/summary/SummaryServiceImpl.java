package com.capgemini.ccsw.estimador.summary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.summary.model.SummaryEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz SummaryService
 *
 */
@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    SummaryRepository summaryRepository;

    @Override
    public List<SummaryEntity> findByEstimationId(Long id) {

        return this.summaryRepository.findByEstimationId(id);
    }

}
