package com.capgemini.ccsw.estimador.criteriacalculationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.ccsw.estimador.criteriacalculation.CriteriaCalculationController;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaDto;

@SpringBootTest
public class CriteriaCalculationTest {

    @Autowired
    CriteriaCalculationController criteriaCalculationController;

    @Test
    public void testIfCriteriaCalculationReturnsRightList() {
        assertNotNull(criteriaCalculationController);

        final Double HOURS = (double) 100;
        final Double VALUE = (double) 15;
        final String TYPE = "% about development";
        final String CONCEPT = "exampleConcept";
        CriteriaCalculationDto body = new CriteriaCalculationDto();
        List<CriteriaDto> list = new ArrayList<CriteriaDto>();
        CriteriaDto criteriaTmp = new CriteriaDto();

        criteriaTmp.setConcept(CONCEPT);
        criteriaTmp.setType(TYPE);
        criteriaTmp.setValue(VALUE);

        list.add(criteriaTmp);

        body.setCriteriaList(list);
        body.setHours(HOURS);

        assertEquals(15,
                criteriaCalculationController.transformation(body).stream().findFirst().orElse(null).getHours());
    }
}
