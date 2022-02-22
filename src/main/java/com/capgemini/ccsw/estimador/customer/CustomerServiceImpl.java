package com.capgemini.ccsw.estimador.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;

/**
 * @author iciudade
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerEntity> findAll(){
		return this.customerRepository.findAll();
	}
}
