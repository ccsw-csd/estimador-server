package com.capgemini.ccsw.estimador.consideration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.consideration.model.ConsiderationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz ConsiderationService
 *
 */
@Service
public class ConsiderationServiceImpl implements ConsiderationService {

    @Autowired
    ConsiderationRepository considerationRepository;

    @Override
    public List<ConsiderationEntity> findByEstimation(Long id) {

        return this.considerationRepository.findByEstimationId(id);
    }
}
