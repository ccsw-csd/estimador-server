package com.capgemini.ccsw.estimador.costpergrade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.costpergrade.model.CostPerGradeDto;

/**
 * @author asolerpa
 *
 *         Controlador que expone las operaciones de negocio de la entidad
 *         CostPerGrade
 *
 */
@RequestMapping(value = "/costpergrade")
@RestController
public class CostPerGradeController {

    @Autowired
    CostPerGradeService costPerGradeService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<CostPerGradeDto> findByEstimationId(@PathVariable Long id) {

        return this.beanMapper.mapList(this.costPerGradeService.findByEstimationId(id), CostPerGradeDto.class);
    }

}
