package com.capgemini.ccsw.criteriaCalculation;

import java.util.List;

import com.capgemini.ccsw.criteriaCalculation.model.CriteriaCalculationBodyDto;
import com.capgemini.ccsw.criteriaCalculation.model.CriteriaCalculationTransformationDto;

public interface CriteriaCalculationService {

    List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationBodyDto body);
}
