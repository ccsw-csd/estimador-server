package com.capgemini.ccsw.estimador.teampyramid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidDto;

/**
 * @author asolerpa
 *
 *         Controlador que expone las operaciones de negocio de la entidad
 *         TeamPyramid
 *
 */
@RequestMapping(value = "/teampyramid")
@RestController
public class TeamPyramidController {

    @Autowired
    TeamPyramidService teamPyramidService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<TeamPyramidDto> findByEstimationId(@PathVariable Long id) {

        return this.beanMapper.mapList(this.teamPyramidService.findByEstimationId(id), TeamPyramidDto.class);
    }

}
