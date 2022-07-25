package com.capgemini.ccsw.estimador.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;

/**
 * @author iciudade
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {

        return this.customerRepository.findAll();
    }

    @Override
    public List<CustomerEntity> findByFilter(String filter) {

        return this.customerRepository.findTop15ByNameContaining(filter);
    }

    @Override
    public CustomerEntity getOrNew(CustomerDto customerDto) {

        CustomerEntity customer = null;

        if (customerDto.getId() != null) {
            customer = customerRepository.findById(customerDto.getId()).orElse(null);
        }

        if (customer == null) {

            customer = new CustomerEntity();
            customer.setName(customerDto.getName());

            customerRepository.save(customer);
        }

        return customer;
    }
}
