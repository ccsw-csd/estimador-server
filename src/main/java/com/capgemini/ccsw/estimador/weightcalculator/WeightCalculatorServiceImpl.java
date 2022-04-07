package com.capgemini.ccsw.estimador.weightcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.weightcalculator.model.TaskDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.WeightCalculatorDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.WeightsDto;

@Service
public class WeightCalculatorServiceImpl implements WeightCalculatorService {

    @Override
    public List<WeightCalculatorDto> calculateWeights(List<TaskDto> taskDtoList, List<WeightsDto> weightsDtoList) {
        List<WeightCalculatorDto> weightCalculatorDtoList = new ArrayList<>();
        HashMap<String, WeightsDto> hashMapOfWeightsDto = new HashMap<>();
        weightsDtoList.stream().forEach(weightsDto -> hashMapOfWeightsDto.put(weightsDto.getElement(), weightsDto));
        taskDtoList.stream()
                .forEach(taskDto -> assignValuesToReturn(weightCalculatorDtoList, taskDto, hashMapOfWeightsDto));
        return weightCalculatorDtoList;
    }

    private void assignValuesToReturn(List<WeightCalculatorDto> weightCalculatorDtoList, TaskDto taskDto,
            HashMap<String, WeightsDto> weightsDto) {
        WeightCalculatorDto weightCalculatorDto = new WeightCalculatorDto();
        if (weightsDto.containsKey(taskDto.getElement())) {
            weightCalculatorDto.setElement(taskDto.getElement());
            weightCalculatorDto.setTaskName(taskDto.getName());
            weightCalculatorDto.setTotalHours(
                    ((taskDto.getVerySimpleCostQuantity() * weightsDto.get(taskDto.getElement()).getVerySimpleCost())
                            + (taskDto.getSimpleCostQuantity() * weightsDto.get(taskDto.getElement()).getSimpleCost())
                            + (taskDto.getMediumCostQuantity() * weightsDto.get(taskDto.getElement()).getMediumCost())
                            + (taskDto.getComplexCostQuantity()
                                    * weightsDto.get(taskDto.getElement()).getComplexCost()))
                            * (1 - taskDto.getPercentageOfReuse() / 100));
            weightCalculatorDtoList.add(weightCalculatorDto);
        }
    }
}
