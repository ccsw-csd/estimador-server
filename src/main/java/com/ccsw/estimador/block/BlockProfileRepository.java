package com.ccsw.estimador.block;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.block.model.BlockProfileEntity;

public interface BlockProfileRepository extends CrudRepository<BlockProfileEntity, Long> {

    @EntityGraph(attributePaths = { "profile", "block" })
    @Override
    List<BlockProfileEntity> findAll();

}
