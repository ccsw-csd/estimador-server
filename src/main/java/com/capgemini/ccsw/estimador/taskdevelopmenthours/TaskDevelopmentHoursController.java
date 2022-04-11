package com.capgemini.ccsw.estimador.taskdevelopmenthours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(path = "", method = RequestMethod.POST)
    public List<TaskDevelopmentHoursDto> findByEstimation(@RequestBody Long id) {

        return this.beanMapper.mapList(this.taskDevelopmentHoursService.findByEstimation(id),
                TaskDevelopmentHoursDto.class);

    }

}
