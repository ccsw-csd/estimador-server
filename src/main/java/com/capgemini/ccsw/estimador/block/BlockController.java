package com.capgemini.ccsw.estimador.block;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.block.model.BlockDto;
import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;

/**
 * @author asolerpa
 *
 *         Controllador que expone las operaciones de negocio de la entidad
 *         Block
 *
 */
@RequestMapping(value = "/block")
@RestController
public class BlockController {

    @Autowired
    BlockService blockService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<BlockDto> findAllBlocks() {

        return this.beanMapper.mapList(this.blockService.findAll(), BlockDto.class);
    }

}
