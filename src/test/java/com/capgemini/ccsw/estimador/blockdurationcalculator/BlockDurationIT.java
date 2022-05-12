package com.capgemini.ccsw.estimador.blockdurationcalculator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.capgemini.ccsw.estimador.block.model.BlockDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.FteDto;
import com.capgemini.ccsw.estimador.config.BaseITAbstract;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

public class BlockDurationIT extends BaseITAbstract {

    public static final String SERVICE_PATH = "/blockdurationcalculator/calculate";
    final Double totalHours = 10d;

    final String fteName = "P1";
    final Double fteNumber = 1d;

    final Long idBlock = 1l;
    final String blockName = "B1";
    final Double criteriaHours = 10d;

    final String profileName = "P1";

    @Test
    void blockDurationCalculatorWroksCorrectlyTest() {

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
        blockDurationCalculatorDto.setFteList(fteList);

        ParameterizedTypeReference<List<BlockDurationTransformatedDto>> responseType = new ParameterizedTypeReference<List<BlockDurationTransformatedDto>>() {
        };

        HttpEntity<?> httpEntity = new HttpEntity<>(blockDurationCalculatorDto, getHeaders());

        ResponseEntity<List<BlockDurationTransformatedDto>> response = this.restTemplate.exchange(LOCALHOST + this.port + SERVICE_PATH, HttpMethod.POST, httpEntity, responseType);

        assertNotNull(response);

    }
}
