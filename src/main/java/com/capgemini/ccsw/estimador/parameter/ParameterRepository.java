package com.capgemini.ccsw.estimador.parameter;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.parameter.model.ParameterEntity;

public interface ParameterRepository extends CrudRepository<ParameterEntity, Long> {

    @EntityGraph(attributePaths = { "block" })
    @Override
    List<ParameterEntity> findAll();

}
