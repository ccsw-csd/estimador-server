package com.capgemini.ccsw.estimador.block;

import java.util.List;

import com.capgemini.ccsw.estimador.block.model.BlockEntity;

/**
 * @author asolerpa
 *
 *         Interfaz que declara las operaciones de negocio de la entidad Block
 *
 */
public interface BlockService {

    List<BlockEntity> findAll();

}
