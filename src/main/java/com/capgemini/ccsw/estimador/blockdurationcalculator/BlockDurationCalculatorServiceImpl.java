package com.capgemini.ccsw.estimador.blockdurationcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.block.BlockProfileService;
import com.capgemini.ccsw.estimador.block.BlockService;
import com.capgemini.ccsw.estimador.block.model.BlockEntity;
import com.capgemini.ccsw.estimador.block.model.BlockProfileEntity;
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

    @Autowired
    BlockProfileService blockProfileService;

    @Override
    public List<BlockDurationTransformatedDto> getHoursGroupedByFte(BlockDurationCalculatorDto blockDurationCalculatorDto) {
        HashMap<String, Double> blockFteList = new HashMap<>();
        Map<String, List<String>> blockProfile = new HashMap<>();

        List<ParameterEntity> parameterEntityList = parameterService.findAll();
        List<BlockEntity> blockEntityList = blockService.findAll();
        List<BlockProfileEntity> blockProfileEntityList = blockProfileService.findAll();

        blockProfileEntityList.stream().forEach(blockProfileEntity -> {
            if (blockProfile.containsKey(blockProfileEntity.getBlock().getName())) {
                blockProfile.get(blockProfileEntity.getBlock().getName()).add(blockProfileEntity.getProfile().getName());
            } else {
                List<String> profileList = new ArrayList<>();
                profileList.add(blockProfileEntity.getProfile().getName());
                blockProfile.put(blockProfileEntity.getBlock().getName(), profileList);
            }
        });

        blockDurationCalculatorDto.getFteList().stream().forEach(fte -> {
            blockProfile.entrySet().stream().forEach(blockProfileEntry -> {
                if (blockProfileEntry.getValue().contains(fte.getName())) {
                    if (blockFteList.containsKey(blockProfileEntry.getKey())) {
                        blockFteList.put(blockProfileEntry.getKey(), blockFteList.get(blockProfileEntry.getKey()) + fte.getPersonNumber());
                    } else {
                        blockFteList.put(blockProfileEntry.getKey(), fte.getPersonNumber());
                    }
                }
            });
        });

        List<BlockDurationTransformatedDto> outputList = createBlocksFromCriteria(blockDurationCalculatorDto, parameterEntityList, blockEntityList);

        outputList.stream().forEach(block -> block.setHours(block.getHours() / 8 / 20 / blockFteList.get(block.getBlockName())));
        BlockDurationTransformatedDto developer = new BlockDurationTransformatedDto();
        developer.setBlockName("Desarrollo");
        developer.setHours(blockDurationCalculatorDto.getHours() / 20 / 8);

        outputList.add(developer);
        return outputList;
    }

    private List<BlockDurationTransformatedDto> createBlocksFromCriteria(BlockDurationCalculatorDto blockDurationCalculatorDto, List<ParameterEntity> parameterEntityList, List<BlockEntity> blockEntityList) {
        HashMap<String, List<CriteriaCalculationTransformationDto>> criteriaHashMap = new HashMap<>();
        for (CriteriaCalculationTransformationDto criteriaCalculationTransformation : blockDurationCalculatorDto.getCriteriaList()) {

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
        return outputList;
    }

    private String findBlockName(List<ParameterEntity> parameterEntityList, List<BlockEntity> blockEntityList, CriteriaCalculationTransformationDto criteriaCalculationTransformation) {
        try {
            return blockEntityList.stream()
                    .filter(block -> block.getId() == parameterEntityList.stream().filter(parameter -> parameter.getConcept().equals(criteriaCalculationTransformation.getConcept())).findFirst().orElse(null).getBlock().getId()).findFirst()
                    .orElse(null).getName();
        } catch (Exception e) {
            System.err.println("Error in com.capgemini.ccsw.estimador.blockdurationcalculator.BlockDurationServiceImpl.findBlockName(): " + criteriaCalculationTransformation.getConcept() + "Not found in parameter concepts list");
            return "";
        }
    }
}
