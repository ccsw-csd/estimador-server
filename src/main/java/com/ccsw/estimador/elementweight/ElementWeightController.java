package com.ccsw.estimador.elementweight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.config.mapper.BeanMapper;
import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.elementweight.model.ElementWeightDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         ElementWeight
 *
 */
@RequestMapping(value = "/elementWeight")
@RestController
public class ElementWeightController {

    @Autowired
    ElementWeightService elementWeightService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public List<ElementWeightDto> findElementWeightsByEstimationCustomer(@RequestBody CustomerDto customer) {

        List<ElementWeightDto> list = this.beanMapper.mapList(this.elementWeightService.findByEstimationCustomer(customer), ElementWeightDto.class);
        list.forEach(i -> i.setId(null));

        return list;

    }

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<ElementWeightDto> findParametersByEstimation(@PathVariable Long id) {

        List<ElementWeightDto> list = this.beanMapper.mapList(this.elementWeightService.findByEstimationId(id), ElementWeightDto.class);
        list.forEach(i -> i.setId(null));

        return list;
    }
}
