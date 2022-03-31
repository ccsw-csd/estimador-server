package com.capgemini.ccsw.estimador.estimationLevel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.estimationLevel.model.EstimationLevelDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         EstimationLevel
 *
 */
@RequestMapping(value = "/estimationLevel")
@RestController
public class EstimationLevelController {

    @Autowired
    EstimationLevelService estimationLevelService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<EstimationLevelDto> findAllBlocks() {

        return this.beanMapper.mapList(this.estimationLevelService.findAll(), EstimationLevelDto.class);
    }

}
