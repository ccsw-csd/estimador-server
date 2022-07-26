package com.ccsw.estimador.block;

import java.util.List;

import com.ccsw.estimador.block.model.BlockProfileEntity;

/**
 * @author dapalmie
 *
 *         Interfaz que declara las operaciones de negocio de la entidad BlockProfile
 *
 */
public interface BlockProfileService {

    List<BlockProfileEntity> findAll();

}
