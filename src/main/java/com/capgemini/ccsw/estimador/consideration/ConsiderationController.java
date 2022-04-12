package com.capgemini.ccsw.estimador.consideration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.consideration.model.ConsiderationDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         Consideration
 *
 */
@RequestMapping(value = "/consideration")
@RestController
public class ConsiderationController {

    @Autowired
    ConsiderationService considerationService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<ConsiderationDto> findByEstimation(@PathVariable Long id) {

        return this.beanMapper.mapList(this.considerationService.findByEstimation(id), ConsiderationDto.class);

    }

}
