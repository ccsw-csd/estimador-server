package com.ccsw.estimador.criteriacalculation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ccsw.estimador.criteriacalculation.CriteriaCalculationServiceImpl;
import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;
import com.ccsw.estimador.criteriacalculation.model.CriteriaDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CriteriaCalculationTest {

   private static final Double HOURS = 100d;
   private static final Double VALUE = 15d;
   private static final String TYPE = "% about development";
   private static final String CONCEPT = "exampleConcept";

   @InjectMocks
   private CriteriaCalculationServiceImpl criteriaCalculationService;

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

      List<CriteriaCalculationTransformationDto> criteriaCalculation = criteriaCalculationService.transformation(dto);

      assertNotNull(criteriaCalculation);
      assertEquals(1, criteriaCalculation.size());
   }
}
