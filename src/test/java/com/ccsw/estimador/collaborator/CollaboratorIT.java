package com.ccsw.estimador.collaborator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ccsw.estimador.collaborator.model.CollaboratorDto;
import com.ccsw.estimador.config.BaseITAbstract;
import com.ccsw.estimador.estimation.model.EstimationDto;

public class CollaboratorIT extends BaseITAbstract {

    public static final String SERVICE_PATH = "/collaborator/";

    @Test
    public void findByEstimationShouldReturnCollaborators() {

        EstimationDto estimation = new EstimationDto();
        estimation.setId(1L);

        ParameterizedTypeReference<List<CollaboratorDto>> responseType = new ParameterizedTypeReference<List<CollaboratorDto>>() {
        };
        HttpEntity<?> httpEntity = new HttpEntity<>(getHeaders());

        ResponseEntity<List<CollaboratorDto>> response = this.restTemplate.exchange(
                LOCALHOST + this.port + SERVICE_PATH + "/estimation/" + estimation.getId(), HttpMethod.GET, httpEntity,
                responseType);

        assertNotNull(response);
        assertEquals(1, response.getBody().size());
    }

}
