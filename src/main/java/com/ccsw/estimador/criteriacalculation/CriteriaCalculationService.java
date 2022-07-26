package com.ccsw.estimador.criteriacalculation;

import java.util.List;

import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public interface CriteriaCalculationService {

    List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationDto criteriaCalculationDto);
}
