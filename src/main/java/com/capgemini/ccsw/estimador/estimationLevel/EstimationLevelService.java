package com.capgemini.ccsw.estimador.estimationLevel;

import java.util.List;

import com.capgemini.ccsw.estimador.estimationLevel.model.EstimationLevelEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         EstimationLevel
 *
 */
public interface EstimationLevelService {

    List<EstimationLevelEntity> findAll();

}
