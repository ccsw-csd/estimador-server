package com.capgemini.ccsw.estimador.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    /**
     * Metodo para recuperar un listado de
     * {@link com.capgemini.ccsw.estimador.customer.model.CustomerEntity}
     *
     * @return
     */
    @Override
    List<CustomerEntity> findAll();

    @Query(value = "select * from customer where name LIKE %:name% LIMIT 15", nativeQuery = true)
    List<CustomerEntity> findByFilter(@Param("name") String filter);

}
