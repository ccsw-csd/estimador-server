package com.capgemini.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorDto;
import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;

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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<CollaboratorDto> findByEstimation(@PathVariable Long id) {

        return this.beanMapper.mapList(this.collaboratorService.findByEstimation(id), CollaboratorDto.class);
    }
}
