package com.ccsw.estimador.block;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.estimador.block.model.BlockProfileEntity;

/**
 * @author dapalmie
 *
 *         Clase que implementa los métodos de la interfaz BlockProfileService
 *
 */
@Service
public class BlockProfileServiceImpl implements BlockProfileService {

    @Autowired
    BlockProfileRepository blockProfileRepository;

    @Override
    public List<BlockProfileEntity> findAll() {

        return this.blockProfileRepository.findAll();

    }

}
