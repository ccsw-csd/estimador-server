package com.capgemini.ccsw.estimador.weighcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.ccsw.estimador.weightcalculator.WeightCalculatorServiceImpl;
import com.capgemini.ccsw.estimador.weightcalculator.model.TaskDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.WeightCalculatorDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.WeightsDto;

@ExtendWith(MockitoExtension.class)
public class WeightCalculatorTest {

    final Double verySimpleCostValue = 1d;

    final Double simpleCostValue = 2d;

    final Double costValue = 3d;

    final Double complexCostValue = 4d;

    final String elementName = "elementName";

    final String taskName = "taskName";

    final Double percentageTest = 10d;

    @InjectMocks
    WeightCalculatorServiceImpl weightCalculatorServiceImpl;

    @Test
    void weightCalculatorWorksCorrectlyTest() {

        TaskDto taskDto = new TaskDto();
        taskDto.setName(taskName);
        taskDto.setElement(elementName);
        taskDto.setVerySimpleCostQuantity(verySimpleCostValue);
        taskDto.setSimpleCostQuantity(simpleCostValue);
        taskDto.setMediumCostQuantity(costValue);
        taskDto.setComplexCostQuantity(complexCostValue);
        taskDto.setPercentageOfReuse(percentageTest);

        WeightsDto weightDto = new WeightsDto();
        weightDto.setElement(elementName);
        weightDto.setMediumCost(costValue);
        weightDto.setVerySimpleCost(verySimpleCostValue);
        weightDto.setSimpleCost(simpleCostValue);
        weightDto.setComplexCost(complexCostValue);

        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();
        taskDtoList.add(taskDto);

        List<WeightsDto> weightsDtoList = new ArrayList<WeightsDto>();
        weightsDtoList.add(weightDto);

        List<WeightCalculatorDto> weightCalculatorDto = weightCalculatorServiceImpl.calculateWeights(taskDtoList,
                weightsDtoList);

        assertNotNull(weightCalculatorDto);
        assertEquals(27d, weightCalculatorDto.stream().filter(item -> item.getElement().equals(elementName)).findFirst()
                .orElse(null).getTotalHours());

    }
}
