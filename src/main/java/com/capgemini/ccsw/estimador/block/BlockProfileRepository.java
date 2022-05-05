package com.capgemini.ccsw.estimador.block;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.block.model.BlockProfileEntity;

public interface BlockProfileRepository extends CrudRepository<BlockProfileEntity, Long> {

    @Override
    List<BlockProfileEntity> findAll();

}
