package com.capgemini.ccsw.estimador.criteriacalculation;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationBodyDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public interface CriteriaCalculationService {

    List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationBodyDto body);
}
