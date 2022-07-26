package com.ccsw.estimador.block;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.block.model.BlockEntity;

/**
 * @author asolerpa
 *
 *         Repositorio que accede a la información de la tabla block en base de
 *         datos
 *
 */
public interface BlockRepository extends CrudRepository<BlockEntity, Long> {

    @Override
    List<BlockEntity> findAll();

}
