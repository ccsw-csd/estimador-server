package com.capgemini.ccsw.estimador.blockdurationcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.block.BlockService;
import com.capgemini.ccsw.estimador.block.model.BlockEntity;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;
import com.capgemini.ccsw.estimador.parameter.ParameterService;
import com.capgemini.ccsw.estimador.parameter.model.ParameterEntity;

@Service
public class BlockDurationCalculatorServiceImpl implements BlockDurationCalculatorService {

    @Autowired
    BlockService blockService;

    @Autowired
    ParameterService parameterService;

    @Override
    public List<BlockDurationTransformatedDto> getHoursGroupedByFte(
            BlockDurationCalculatorDto blockDurationCalculatorDto) {

        List<ParameterEntity> parameterEntityList = parameterService.findAll();
        List<BlockEntity> blockEntityList = blockService.findAll();
        HashMap<String, List<CriteriaCalculationTransformationDto>> criteriaHashMap = new HashMap<>();
        for (CriteriaCalculationTransformationDto criteriaCalculationTransformation : blockDurationCalculatorDto
                .getCriteriaList()) {

            String blockName = findBlockName(parameterEntityList, blockEntityList, criteriaCalculationTransformation);

            if (!criteriaHashMap.containsKey(blockName)) {
                List<CriteriaCalculationTransformationDto> tmpCriteriaList = new ArrayList<>();
                tmpCriteriaList.add(criteriaCalculationTransformation);
                criteriaHashMap.put(blockName, tmpCriteriaList);
            } else {
                criteriaHashMap.get(blockName).add(criteriaCalculationTransformation);
            }
        }

        List<BlockDurationTransformatedDto> outputList = new ArrayList<>();

        for (String key : criteriaHashMap.keySet()) {
            BlockDurationTransformatedDto tmp = new BlockDurationTransformatedDto();
            criteriaHashMap.get(key).stream().forEach(criteria -> tmp.setHours(criteria.getHours() + tmp.getHours()));
            tmp.setBlockName(key);
            outputList.add(tmp);
        }
        BlockDurationTransformatedDto developer = new BlockDurationTransformatedDto();
        developer.setBlockName("Desarrollo");
        developer.setHours(blockDurationCalculatorDto.getHours());

        // FALTA ÚLTIMO PASO QUE ES RECORRER LA LISTA DE TRANSFORMACIONES DE SALIDA Y
        // HACER LA OPERACIÓN horas/8/20/número de FTE totales.
        // COMO NO SE ENTENDÍA MUY BIEN ESA PARTE, NO HE CONSEGUIDO SACARLO.
        outputList.add(developer);
        // OUTPUTLIST ES EL LISTADO DEFINITIVO CON LOS BLOQUES
        return outputList;
    }

    private String findBlockName(List<ParameterEntity> parameterEntityList, List<BlockEntity> blockEntityList,
            CriteriaCalculationTransformationDto criteriaCalculationTransformation) {
        try {
            return blockEntityList.stream().filter(block -> block.getId() == parameterEntityList.stream()
                    .filter(parameter -> parameter.getConcept().equals(criteriaCalculationTransformation.getConcept()))
                    .findFirst().orElse(null).getBlock().getId()).findFirst().orElse(null).getName();
        } catch (Exception e) {
            System.err.println(
                    "Error in com.capgemini.ccsw.estimador.blockdurationcalculator.BlockDurationServiceImpl.findBlockName(): "
                            + criteriaCalculationTransformation.getConcept() + "Not found in parameter concepts list");
            return "";
        }
    }
}
