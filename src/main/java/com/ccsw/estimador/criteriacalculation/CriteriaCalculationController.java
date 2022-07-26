package com.ccsw.estimador.criteriacalculation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationDto;
import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

@RestController
@RequestMapping(value = "/criteriacalculation")
public class CriteriaCalculationController {

    @Autowired
    CriteriaCalculationService criteriaCalculationService;

    @RequestMapping(path = "/calculate", method = RequestMethod.POST)
    public List<CriteriaCalculationTransformationDto> calculatePercentagesWithCriteria(
            @RequestBody CriteriaCalculationDto criteriaCalculationDto) {
        return criteriaCalculationService.transformation(criteriaCalculationDto);
    }
}
