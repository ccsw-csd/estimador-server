package com.capgemini.ccsw.estimador.teampyramid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz TeamPyramidService
 *
 */
@Service
public class TeamPyramidServiceImpl implements TeamPyramidService {

    @Autowired
    TeamPyramidRepository teamPyramidRepository;

    @Override
    public List<TeamPyramidEntity> findByEstimationId(Long id) {

        return this.teamPyramidRepository.findByEstimationId(id);
    }

}
