package com.ccsw.estimador.customer;

import java.util.List;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.customer.model.CustomerEntity;

/**
 * @author iciudade
 */
public interface CustomerService {

    /**
     * Metodo para recuperar un listado de
     * {@link com.ccsw.estimador.customer.model.CustomerEntity}
     *
     * @return
     */
    List<CustomerEntity> findAll();

    List<CustomerEntity> findByFilter(String filter);

    CustomerEntity getOrNew(CustomerDto customer);
}
