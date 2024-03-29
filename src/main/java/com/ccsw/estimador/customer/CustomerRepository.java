package com.ccsw.estimador.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.customer.model.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    /**
     * Metodo para recuperar un listado de
     * {@link com.ccsw.estimador.customer.model.CustomerEntity}
     *
     * @return
     */
    @Override
    List<CustomerEntity> findAll();

    List<CustomerEntity> findTop15ByNameContaining(String filter);

}
