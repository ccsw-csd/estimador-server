package com.capgemini.ccsw.estimador.criteriacalculation;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public interface CriteriaCalculationService {

    List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationDto criteriaCalculationDto);
}
