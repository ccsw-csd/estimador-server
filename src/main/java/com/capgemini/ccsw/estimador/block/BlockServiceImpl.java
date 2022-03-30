package com.capgemini.ccsw.estimador.block;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.block.model.BlockEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz BlockService
 *
 */
@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockRepository blockRepository;

    @Override
    public List<BlockEntity> findAll() {

        return this.blockRepository.findAll();

    }

}
