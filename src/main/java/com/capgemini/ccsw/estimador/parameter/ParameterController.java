package com.capgemini.ccsw.estimador.parameter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(path = "customer", method = RequestMethod.POST)
    public List<ParameterDto> findParametersByEstimationCustomer(@RequestBody CustomerDto customer) {

        return this.beanMapper.mapList(this.parameterService.findParametersByEstimationCustomer(customer), ParameterDto.class);
    }

}
