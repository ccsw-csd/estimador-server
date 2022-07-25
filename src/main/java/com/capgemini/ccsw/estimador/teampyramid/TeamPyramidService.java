package com.capgemini.ccsw.estimador.teampyramid;

import java.util.List;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad
 *         TeamPyramid
 *
 */
public interface TeamPyramidService {

    List<TeamPyramidEntity> findByEstimationId(Long id);

    void saveEstimation(EstimationEntity estimation, EstimationEditDto data);

}
