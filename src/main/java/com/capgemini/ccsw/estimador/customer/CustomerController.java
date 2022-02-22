package com.capgemini.ccsw.estimador.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.customer.model.CustomerDto;

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
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<CustomerDto> findAll(){
		return this.beanMapper.mapList(customerService.findAll(), CustomerDto.class);
	}

}
