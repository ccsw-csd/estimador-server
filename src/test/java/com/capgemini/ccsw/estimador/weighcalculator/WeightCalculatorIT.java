package com.capgemini.ccsw.estimador.weighcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.capgemini.ccsw.estimador.config.BaseITAbstract;
import com.capgemini.ccsw.estimador.weightcalculator.model.TaskAndWeightsDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.TaskDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.WeightCalculatorDto;
import com.capgemini.ccsw.estimador.weightcalculator.model.WeightsDto;

public class WeightCalculatorIT extends BaseITAbstract {

    public static final String SERVICE_PATH = "/weightcalculator/calculate";

    final Double verySimpleCostValue = 1d;

    final Double simpleCostValue = 2d;

    final Double costValue = 3d;

    final Double complexCostValue = 4d;

    final String elementName = "elementName";

    final String taskName = "taskName";

    final Double percentageTest = 10d;

    @Test
    void restWeightCalculatorTest() {
        TaskDto taskDto = new TaskDto();
        taskDto.setName(taskName);
        taskDto.setElement(elementName);
        taskDto.setVerySimpleCostQuantity(verySimpleCostValue);
        taskDto.setSimpleCostQuantity(simpleCostValue);
        taskDto.setCostQuantity(costValue);
        taskDto.setComplexCostQuantity(complexCostValue);
        taskDto.setPercentageOfReuse(percentageTest);

        WeightsDto weightDto = new WeightsDto();
        weightDto.setElement(elementName);
        weightDto.setCost(costValue);
        weightDto.setVerySimpleCost(verySimpleCostValue);
        weightDto.setSimpleCost(simpleCostValue);
        weightDto.setComplexCost(complexCostValue);

        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();
        taskDtoList.add(taskDto);

        List<WeightsDto> weightsDtoList = new ArrayList<WeightsDto>();
        weightsDtoList.add(weightDto);

        TaskAndWeightsDto taskAndWeightsDto = new TaskAndWeightsDto();
        taskAndWeightsDto.setTasks(taskDtoList);
        taskAndWeightsDto.setWeights(weightsDtoList);

        ParameterizedTypeReference<List<WeightCalculatorDto>> responseType = new ParameterizedTypeReference<List<WeightCalculatorDto>>() {
        };
        HttpEntity<?> httpEntity = new HttpEntity<>(taskAndWeightsDto, getHeaders());

        ResponseEntity<List<WeightCalculatorDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH,
                HttpMethod.POST, httpEntity, responseType);

        assertEquals(27d, response.getBody().stream().findFirst().orElse(null).getTotalHours());
    }
}