package com.ccsw.estimador.weightcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ccsw.estimador.weightcalculator.model.TaskDto;
import com.ccsw.estimador.weightcalculator.model.WeightCalculatorDto;
import com.ccsw.estimador.weightcalculator.model.WeightsDto;

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
        if (weightsDto.containsKey(taskDto.getElementName())) {
            weightCalculatorDto.setElement(taskDto.getElementName());
            weightCalculatorDto.setTaskName(taskDto.getName());
            weightCalculatorDto.setTotalHours(
                    ((taskDto.getQuantityVerySimple() * weightsDto.get(taskDto.getElementName()).getVerySimple())
                            + (taskDto.getQuantitySimple() * weightsDto.get(taskDto.getElementName()).getSimple())
                            + (taskDto.getQuantityMedium() * weightsDto.get(taskDto.getElementName()).getMedium())
                            + (taskDto.getQuantityComplex() * weightsDto.get(taskDto.getElementName()).getComplex()))
                            * (1 - taskDto.getReusability() / 100));
            weightCalculatorDtoList.add(weightCalculatorDto);
        }
    }
}
