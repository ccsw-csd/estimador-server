package com.capgemini.ccsw.estimador.elementweight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.elementweight.model.ElementWeightDto;

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

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<ElementWeightDto> findElementWeightsByEstimationId(@PathVariable Long id) {

        return this.beanMapper.mapList(this.elementWeightService.findByEstimationId(id), ElementWeightDto.class);
    }

    @RequestMapping(path = "customer", method = RequestMethod.POST)
    public List<ElementWeightDto> findElementWeightsByEstimationCustomer(@RequestBody CustomerDto customer) {

        return this.beanMapper.mapList(this.elementWeightService.findByEstimationCustomer(customer),
                ElementWeightDto.class);
    }

}
