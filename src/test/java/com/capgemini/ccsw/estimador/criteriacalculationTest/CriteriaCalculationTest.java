package com.capgemini.ccsw.estimador.criteriacalculationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.ccsw.estimador.criteriacalculation.CriteriaCalculationController;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationBodyDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;

@SpringBootTest
public class CriteriaCalculationTest {

    @Autowired
    CriteriaCalculationController criteriaCalculationController;

    @Test
    public void testIfCriteriaCalculationReturnsRightList() {
        assertNotNull(criteriaCalculationController);

        CriteriaCalculationBodyDto body = new CriteriaCalculationBodyDto();
        List<CriteriaCalculationDto> list = new ArrayList<CriteriaCalculationDto>();
        CriteriaCalculationDto criteriaTmp = new CriteriaCalculationDto();

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
