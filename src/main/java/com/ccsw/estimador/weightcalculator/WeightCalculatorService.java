package com.ccsw.estimador.weightcalculator;

import java.util.List;

import com.ccsw.estimador.weightcalculator.model.TaskDto;
import com.ccsw.estimador.weightcalculator.model.WeightCalculatorDto;
import com.ccsw.estimador.weightcalculator.model.WeightsDto;

public interface WeightCalculatorService {

    List<WeightCalculatorDto> calculateWeights(List<TaskDto> taskDtoList, List<WeightsDto> weightsDtoList);
}
