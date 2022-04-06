package com.capgemini.ccsw.estimador.block;

import com.capgemini.ccsw.estimador.block.model.BlockDto;
import com.capgemini.ccsw.estimador.config.BaseITAbstract;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BlockIT extends BaseITAbstract {

   public static final String SERVICE_PATH = "/block/";

   @Test
   public void findAllBlocksShouldReturnBlocks() {
      ParameterizedTypeReference<List<BlockDto>> responseType = new ParameterizedTypeReference<List<BlockDto>>(){};
      HttpEntity<?> httpEntity = new HttpEntity<>(getHeaders());

      ResponseEntity<List<BlockDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, httpEntity, responseType);

      assertNotNull(response);
      assertEquals(3, response.getBody().size());
   }

}
