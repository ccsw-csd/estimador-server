package com.capgemini.ccsw.criteriaCalculation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ccsw.criteriaCalculation.model.CriteriaCalculationBodyDto;
import com.capgemini.ccsw.criteriaCalculation.model.CriteriaCalculationDto;
import com.capgemini.ccsw.criteriaCalculation.model.CriteriaCalculationTransformationDto;

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
