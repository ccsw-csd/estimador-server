package com.capgemini.ccsw.estimador.blockdurationcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.capgemini.ccsw.estimador.config.BaseITAbstract;
import com.ccsw.estimador.block.model.BlockDto;
import com.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;
import com.ccsw.estimador.blockdurationcalculator.model.FteDto;
import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public class BlockDurationIT extends BaseITAbstract {

    final Double totalHours = 10d;

    final String fteName = "P1";
    final Double fteNumber = 1d;

    final Long idBlock = 1l;
    final String blockName = "B1";
    final Double criteriaHours = 10d;

    final String profileName = "P1";

    @Test
    void blockDurationCalculatorWroksCorrectlyTest() {

        final String SERVICE_PATH = "/blockdurationcalculator/calculate";

        BlockDurationCalculatorDto blockDurationCalculatorDto = new BlockDurationCalculatorDto();

        blockDurationCalculatorDto.setHours(totalHours);

        List<FteDto> fteList = new ArrayList<>();
        FteDto fteDto = new FteDto();
        fteDto.setName(fteName);
        fteDto.setPersonNumber(fteNumber);
        fteList.add(fteDto);
        blockDurationCalculatorDto.setFteList(fteList);
        List<CriteriaCalculationTransformationDto> criteriaList = new ArrayList<>();
        CriteriaCalculationTransformationDto criteriaDto = new CriteriaCalculationTransformationDto();
        BlockDto block = new BlockDto();
        block.setId(idBlock);
        block.setName(blockName);
        criteriaDto.setBlock(block);
        criteriaDto.setHours(criteriaHours);
        criteriaList.add(criteriaDto);
        blockDurationCalculatorDto.setCriteriaList(criteriaList);

        ParameterizedTypeReference<List<BlockDurationTransformatedDto>> responseType = new ParameterizedTypeReference<List<BlockDurationTransformatedDto>>() {
        };

        HttpEntity<?> httpEntity = new HttpEntity<>(blockDurationCalculatorDto, getHeaders());

        ResponseEntity<List<BlockDurationTransformatedDto>> response = this.restTemplate.exchange(LOCALHOST + this.port + SERVICE_PATH, HttpMethod.POST, httpEntity, responseType);

        assertNotNull(response);

        List<BlockDurationTransformatedDto> list = response.getBody();
        assertEquals(0.0625, list.get(list.size() - 1).getDuration());

    }

    @Test
    void projectTotalDurationWorksCorrectlyTest() {
        final String SERVICE_PATH = "/blockdurationcalculator/calculate-total";
        List<BlockDurationTransformatedDto> blockDurationTransformatedDto = new ArrayList();
        BlockDurationTransformatedDto blockDto = new BlockDurationTransformatedDto();
        blockDto.setBlockName("Desarrollo");
        blockDto.setDuration(0.0625d);
        blockDurationTransformatedDto.add(blockDto);

        ParameterizedTypeReference<Double> responseType = new ParameterizedTypeReference<Double>() {
        };

        HttpEntity<?> httpEntity = new HttpEntity<>(blockDurationTransformatedDto, getHeaders());

        ResponseEntity<Double> response = this.restTemplate.exchange(LOCALHOST + this.port + SERVICE_PATH, HttpMethod.POST, httpEntity, responseType);

        assertNotNull(response);

        assertEquals(0.0625d, response.getBody());

    }
}
