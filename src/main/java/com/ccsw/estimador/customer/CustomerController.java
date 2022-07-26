package com.ccsw.estimador.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.config.mapper.BeanMapper;
import com.ccsw.estimador.customer.model.CustomerDto;

/**
 *
 * @author iciudade
 *
 */
@RequestMapping(value = "/customer/")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CustomerDto> findAll() {

        return this.beanMapper.mapList(this.customerService.findAll(), CustomerDto.class);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public List<CustomerDto> findByFilter(@RequestBody String filter) {

        return this.beanMapper.mapList(this.customerService.findByFilter(filter), CustomerDto.class);
    }
}
