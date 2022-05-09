package com.capgemini.ccsw.estimador.block;

import java.util.List;

import com.capgemini.ccsw.estimador.block.model.BlockProfileEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad Block
 *
 */
public interface BlockProfileService {

    List<BlockProfileEntity> findAll();

}
