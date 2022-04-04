package com.capgemini.ccsw.estimador.criteriaCalculation;

import java.util.List;

import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationTransformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.criteriaCalculation.model.CriteriaCalculationBodyDto;

@RestController
@RequestMapping(value = "/critcalculation")
public class CriteriaCalculationController {

    @Autowired
    CriteriaCalculationService criteriaCalculationService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public List<CriteriaCalculationTransformationDto> transformation(
            @RequestBody CriteriaCalculationBodyDto criteriaCalculationBodyDto) {
        return criteriaCalculationService.transformation(criteriaCalculationBodyDto);
    }
}
