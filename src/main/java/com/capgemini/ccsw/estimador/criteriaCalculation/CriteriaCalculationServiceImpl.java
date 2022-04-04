package com.capgemini.ccsw.estimador.criteriaCalculation;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationTransformationDto;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationBodyDto;

@Service
public class CriteriaCalculationServiceImpl implements CriteriaCalculationService {

    @Override
    public List<CriteriaCalculationTransformationDto> transformation(CriteriaCalculationBodyDto body) {
        double hours = body.getHours();
        List<CriteriaCalculationTransformationDto> list = new ArrayList<>();

        for (CriteriaCalculationDto element : body.getCriteriaList()) {
            CriteriaCalculationTransformationDto returned = new CriteriaCalculationTransformationDto();
            returned.setHours(element.getValue() * hours / 100);
            returned.setType(element.getType());
            list.add(returned);
        }
        return list;
    }
}
