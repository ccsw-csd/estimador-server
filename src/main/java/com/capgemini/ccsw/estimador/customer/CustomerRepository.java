package com.capgemini.ccsw.estimador.customer;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{

	
}
