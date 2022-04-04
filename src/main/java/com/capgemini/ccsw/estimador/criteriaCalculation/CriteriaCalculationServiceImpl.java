package com.capgemini.ccsw.estimador.criteriacalculation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationBodyDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

@Service
public class CriteriaCalculationServiceImpl implements CriteriaCalculationService {

    @Override
    public List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationBodyDto body) {
        double hours = body.getHours();
        List<CriteriaCalculationTransformationDto> list = new ArrayList<>();

        for (CriteriaCalculationDto element : body.getCriteriaList()) {
            CriteriaCalculationTransformationDto returned = new CriteriaCalculationTransformationDto();
            if(element.getType().equals("% about development")) {
            	returned.setHours(element.getValue() * hours / 100);
            	returned.setConcept(element.getConcept());
            	list.add(returned);
            }
        }
        return list;
    }
}
