package com.capgemini.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorDto;
import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         Collaborator
 *
 */
@RequestMapping(value = "/collaborator")
@RestController
public class CollaboratorController {

    @Autowired
    CollaboratorService collaboratorService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public List<CollaboratorDto> findByEstimation(@RequestBody EstimationDto estimation) {

        return this.beanMapper.mapList(
                this.collaboratorService.findByEstimation(this.beanMapper.map(estimation, EstimationEntity.class)),
                CollaboratorDto.class);
    }
}
