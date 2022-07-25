package com.capgemini.ccsw.estimador.parameter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.parameter.model.ParameterDto;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         Parameter
 *
 */
@RequestMapping(value = "/parameter")
@RestController
public class ParameterController {

    @Autowired
    ParameterService parameterService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public List<ParameterDto> findParametersByEstimationCustomer(@RequestBody CustomerDto customer) {

        List<ParameterDto> list = this.beanMapper.mapList(this.parameterService.findParametersByEstimationCustomer(customer), ParameterDto.class);
        list.forEach(i -> i.setId(null));

        return list;

    }

    @RequestMapping(path = "/estimation/{id}", method = RequestMethod.GET)
    public List<ParameterDto> findParametersByEstimation(@PathVariable Long id) {

        List<ParameterDto> list = this.beanMapper.mapList(this.parameterService.findParametersByEstimationId(id), ParameterDto.class);
        list.forEach(i -> i.setId(null));

        return list;

    }

}
