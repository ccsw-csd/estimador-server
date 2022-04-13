package com.capgemini.ccsw.estimador.estimationlevel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.estimationlevel.model.EstimationLevelEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz
 *         EstimationLevelService
 *
 */
@Service
public class EstimationLevelServiceImpl implements EstimationLevelService {

    @Autowired
    EstimationLevelRepository estimationLevelRepository;

    @Override
    public List<EstimationLevelEntity> findAll() {

        return this.estimationLevelRepository.findAll();

    }

}
