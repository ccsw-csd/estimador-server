package com.capgemini.ccsw.estimador.block;

import java.util.List;

import com.capgemini.ccsw.estimador.block.model.BlockEntity;

/**
 * @author dapalmie
 *
 *         Interfaz que declara las operaciones de negocio de la entidad BlockProfile
 *
 */
public interface BlockService {

    List<BlockEntity> findAll();

    BlockEntity get(Long id);

}
