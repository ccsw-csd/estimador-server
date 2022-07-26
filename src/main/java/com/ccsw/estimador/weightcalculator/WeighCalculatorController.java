package com.ccsw.estimador.weightcalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.weightcalculator.model.TaskAndWeightsDto;
import com.ccsw.estimador.weightcalculator.model.WeightCalculatorDto;

@RestController
@RequestMapping(value = "/weightcalculator")
public class WeighCalculatorController {

    @Autowired
    WeightCalculatorService weightCalculatorService;

    @RequestMapping(path = "/calculate", method = RequestMethod.POST)
    public List<WeightCalculatorDto> calculateWeights(@RequestBody TaskAndWeightsDto taskAndWeightsDto) {
        return weightCalculatorService.calculateWeights(taskAndWeightsDto.getTasks(), taskAndWeightsDto.getWeights());
    }
}
