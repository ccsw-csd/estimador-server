package com.capgemini.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         TaskDevelopmentHours
 *
 */
@RequestMapping(value = "/taskDevelopmentHours")
@RestController
public class TaskDevelopmentHoursController {

    @Autowired
    TaskDevelopmentHoursService taskDevelopmentHoursService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<TaskDevelopmentHoursDto> findByEstimationId(@PathVariable Long id) {

        return this.beanMapper.mapList(this.taskDevelopmentHoursService.findByEstimationId(id),
                TaskDevelopmentHoursDto.class);

    }

}
