package com.capgemini.ccsw.estimador.weightcalculator;

import java.util.ArrayList;
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

        for (TaskDto taskDto : taskDtoList) {
            for (WeightsDto weightsDto : weightsDtoList) {
                if (taskDto.getElement().equals(weightsDto.getElement())) {
                    WeightCalculatorDto weightCalculatorDto = new WeightCalculatorDto();
                    weightCalculatorDto.setElement(taskDto.getElement());
                    weightCalculatorDto.setTaskName(taskDto.getName());
                    weightCalculatorDto
                            .setTotalHours(((taskDto.getVerySimpleCostQuantity() * weightsDto.getVerySimpleCost())
                                    + (taskDto.getSimpleCostQuantity() * weightsDto.getSimpleCost())
                                    + (taskDto.getMediumCostQuantity() * weightsDto.getMediumCost())
                                    + (taskDto.getComplexCostQuantity() * weightsDto.getComplexCost()))
                                    * (1 - taskDto.getPercentageOfReuse() / 100));
                    weightCalculatorDtoList.add(weightCalculatorDto);
                }
            }
        }
        return weightCalculatorDtoList;
    }
}
