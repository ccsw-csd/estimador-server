package com.capgemini.ccsw.estimador.taskarchitecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         TaskArchitecture
 *
 */
@RequestMapping(value = "/taskArchitecture")
@RestController
public class TaskArchitectureController {

    @Autowired
    TaskArchitectureService taskArchitectureService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<TaskArchitectureDto> findByEstimation(@PathVariable Long id) {

        return this.beanMapper.mapList(this.taskArchitectureService.findByEstimation(id), TaskArchitectureDto.class);

    }

}
