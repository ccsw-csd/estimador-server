package com.capgemini.ccsw.estimador.block;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ccsw.estimador.block.BlockRepository;
import com.ccsw.estimador.block.BlockServiceImpl;
import com.ccsw.estimador.block.model.BlockEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlockTest {

   @Mock
   private BlockRepository blockRepository;

   @InjectMocks
   private BlockServiceImpl blockService;

   @Test
   public void findAllBlocksShouldReturnBlocks() {

      List<BlockEntity> list = new ArrayList<>();
      list.add(mock(BlockEntity.class));

      when(blockRepository.findAll()).thenReturn(list);

      List<BlockEntity> blocks = blockService.findAll();

      assertNotNull(blocks);
      assertEquals(1, blocks.size());
   }
}
