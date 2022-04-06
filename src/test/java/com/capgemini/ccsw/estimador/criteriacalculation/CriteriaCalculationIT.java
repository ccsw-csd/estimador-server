package com.capgemini.ccsw.estimador.criteriacalculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.ccsw.estimador.config.BaseITAbstract;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;
import org.junit.jupiter.api.Test;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class CriteriaCalculationIT extends BaseITAbstract {

    public static final String SERVICE_PATH = "/criteriacalculation/calculate";

    private static final Double HOURS = 100d;
    private static final Double VALUE = 15d;
    private static final String TYPE = "% about development";
    private static final String CONCEPT = "exampleConcept";

    @Test
    public void calculateCriteriaCalculationShouldReturnRightList() {

        CriteriaDto criteria = new CriteriaDto();
        criteria.setConcept(CONCEPT);
        criteria.setType(TYPE);
        criteria.setValue(VALUE);

        List<CriteriaDto> list = new ArrayList<>();
        list.add(criteria);

        CriteriaCalculationDto dto = new CriteriaCalculationDto();
        dto.setCriteriaList(list);
        dto.setHours(HOURS);

        ParameterizedTypeReference<List<CriteriaCalculationTransformationDto>> responseType = new ParameterizedTypeReference<List<CriteriaCalculationTransformationDto>>(){};
        HttpEntity<?> httpEntity = new HttpEntity<>(dto, getHeaders());

        ResponseEntity<List<CriteriaCalculationTransformationDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.POST, httpEntity, responseType);

        assertEquals(15, response.getBody().stream().findFirst().orElse(null).getHours());
    }
}
