package com.capgemini.ccsw.estimador.estimationlevel;

import java.util.List;

import com.capgemini.ccsw.estimador.estimationlevel.model.EstimationLevelEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         EstimationLevel
 *
 */
public interface EstimationLevelService {

    List<EstimationLevelEntity> findAll();

    EstimationLevelEntity get(Long id);

}
