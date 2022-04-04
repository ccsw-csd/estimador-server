package com.capgemini.ccsw.estimador.criteriaCalculation;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationBodyDto;
import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationTransformationDto;

public interface CriteriaCalculationService {

    List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationBodyDto body);
}
