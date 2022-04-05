package com.capgemini.ccsw.estimador.criteriacalculation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaDto;

@Service
public class CriteriaCalculationServiceImpl implements CriteriaCalculationService {

    private static final String CRITERIA_LISTED_NAMES = "% about development";

    @Override
    public List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationDto criteriaCalculationDto) {
        Double hours = criteriaCalculationDto.getHours();
        List<CriteriaCalculationTransformationDto> list = new ArrayList<>();

        for (CriteriaDto element : criteriaCalculationDto.getCriteriaList()) {
            CriteriaCalculationTransformationDto returned = new CriteriaCalculationTransformationDto();
            if (element.getType().equals(CRITERIA_LISTED_NAMES)) {
                returned.setHours(element.getValue() * hours / 100);
                returned.setConcept(element.getConcept());
                list.add(returned);
            }
        }
        return list;
    }
}