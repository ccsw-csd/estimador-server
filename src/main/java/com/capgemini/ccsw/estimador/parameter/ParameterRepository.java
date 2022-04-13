package com.capgemini.ccsw.estimador.parameter;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.parameter.model.ParameterEntity;

public interface ParameterRepository extends CrudRepository<ParameterEntity, Long> {

}
