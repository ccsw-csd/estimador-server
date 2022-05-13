package com.capgemini.ccsw.estimador.summary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.summary.model.SummaryDto;

/**
 * @author asolerpa
 *
 *         Controlador que expone las operaciones de negocio de la entidad
 *         Summary
 *
 */
@RequestMapping(value = "/summary")
@RestController
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<SummaryDto> findByEstimationId(@PathVariable Long id) {

        return this.beanMapper.mapList(this.summaryService.findByEstimationId(id), SummaryDto.class);
    }

}
