package com.capgemini.ccsw.estimador.estimation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationSearchDto;

/**
 * @author iciudade
 */
@RequestMapping(value = "/estimation")
@RestController
public class EstimationController {

  @Autowired
  EstimationService estimationService;

  @Autowired
  BeanMapper beanMapper;

  @RequestMapping(path = "", method = RequestMethod.POST)
  public Page<EstimationDto> findPage(@RequestBody EstimationSearchDto dto) {

    return this.beanMapper.mapPage(this.estimationService.findPage(dto), EstimationDto.class);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public EstimationDto getEstimation(@PathVariable Long id) {

    return this.beanMapper.map(this.estimationService.getEstimation(id), EstimationDto.class);
  }

}
