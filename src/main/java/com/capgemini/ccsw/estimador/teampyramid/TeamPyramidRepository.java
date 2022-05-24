package com.capgemini.ccsw.estimador.teampyramid;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla team_pyramid en
 *         base de datos
 *
 */
public interface TeamPyramidRepository extends CrudRepository<TeamPyramidEntity, Long> {

    List<TeamPyramidEntity> findByEstimationId(Long estimationId);

}
