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

    final Double mediumCostValue = 3d;

    final Double complexCostValue = 4d;

    final String elementName = "elementName";

    final String taskName = "taskName";

    final Double percentageTest = 10d;

    @InjectMocks
    WeightCalculatorServiceImpl weightCalculatorServiceImpl;

    @Test
    void weightCalculatorWorksCorrectlyTest() {

        TaskDto taskDto = new TaskDto();
        taskDto.setName(this.taskName);
        taskDto.setElementName(this.elementName);
        taskDto.setQuantityVerySimple(this.verySimpleCostValue);
        taskDto.setQuantitySimple(this.simpleCostValue);
        taskDto.setQuantityMedium(this.mediumCostValue);
        taskDto.setQuantityComplex(this.complexCostValue);
        taskDto.setReusability(this.percentageTest);

        WeightsDto weightDto = new WeightsDto();
        weightDto.setElement(this.elementName);
        weightDto.setMedium(this.mediumCostValue);
        weightDto.setVerySimple(this.verySimpleCostValue);
        weightDto.setSimple(this.simpleCostValue);
        weightDto.setComplex(this.complexCostValue);

        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();
        taskDtoList.add(taskDto);

        List<WeightsDto> weightsDtoList = new ArrayList<WeightsDto>();
        weightsDtoList.add(weightDto);

        List<WeightCalculatorDto> weightCalculatorDto = this.weightCalculatorServiceImpl.calculateWeights(taskDtoList,
                weightsDtoList);

        assertNotNull(weightCalculatorDto);
        assertEquals(27d, weightCalculatorDto.stream().filter(item -> item.getElement().equals(this.elementName))
                .findFirst().orElse(null).getTotalHours());

    }
}
