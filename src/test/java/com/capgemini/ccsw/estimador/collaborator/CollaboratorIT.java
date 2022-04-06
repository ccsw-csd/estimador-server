package com.capgemini.ccsw.estimador.collaborator;

import com.capgemini.ccsw.estimador.collaborator.model.CollaboratorDto;
import com.capgemini.ccsw.estimador.config.BaseITAbstract;
import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CollaboratorIT extends BaseITAbstract {

   public static final String SERVICE_PATH = "/collaborator/";

   @Test
   public void findByEstimationShouldReturnCollaborators() {

      EstimationDto estimation = new EstimationDto();
      estimation.setId(1L);

      ParameterizedTypeReference<List<CollaboratorDto>> responseType = new ParameterizedTypeReference<List<CollaboratorDto>>(){};
      HttpEntity<?> httpEntity = new HttpEntity<>(estimation, getHeaders());

      ResponseEntity<List<CollaboratorDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.POST, httpEntity, responseType);

      assertNotNull(response);
      assertEquals(1, response.getBody().size());
   }

}
