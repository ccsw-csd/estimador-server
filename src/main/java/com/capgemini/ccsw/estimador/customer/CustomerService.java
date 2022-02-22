package com.capgemini.ccsw.estimador.customer;

import java.util.List;

import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;

/**
 * @author iciudade
 */
public interface CustomerService {
	
	/**
	 * Metodo para recuperar un listado de {@link com.capgemini.ccsw.estimador.customer.model.CustomerEntity}
	 * @return
	 */
	List<CustomerEntity> findAll();

}
