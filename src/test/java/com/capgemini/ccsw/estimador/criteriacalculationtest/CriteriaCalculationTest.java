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

        CriteriaCalculationDto body = new CriteriaCalculationDto();
        List<CriteriaDto> list = new ArrayList<CriteriaDto>();
        CriteriaDto criteriaTmp = new CriteriaDto();

        criteriaTmp.setConcept("hola");
        criteriaTmp.setType("% about development");
        criteriaTmp.setValue(15);

        list.add(criteriaTmp);

        body.setCriteriaList(list);
        body.setHours(100);

        assertEquals(15,
                criteriaCalculationController.transformation(body).stream().findFirst().orElse(null).getHours());
    }
}
