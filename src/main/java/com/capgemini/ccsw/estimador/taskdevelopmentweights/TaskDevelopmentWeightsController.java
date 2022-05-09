package com.capgemini.ccsw.estimador.taskdevelopmentweights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         TaskDevelopmentWeights
 *
 */
@RequestMapping(value = "/taskDevelopmentWeights")
@RestController
public class TaskDevelopmentWeightsController {

    @Autowired
    TaskDevelopmentWeightsService taskDevelopmentWeightsService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<TaskDevelopmentWeightsDto> findByEstimationId(@PathVariable Long id) {

        return this.beanMapper.mapList(this.taskDevelopmentWeightsService.findByEstimationId(id),
                TaskDevelopmentWeightsDto.class);

    }

}
