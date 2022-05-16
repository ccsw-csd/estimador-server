package com.capgemini.ccsw.estimador.blockdurationcalculator;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.block.BlockProfileService;
import com.capgemini.ccsw.estimador.block.BlockService;
import com.capgemini.ccsw.estimador.block.model.BlockDto;
import com.capgemini.ccsw.estimador.block.model.BlockEntity;
import com.capgemini.ccsw.estimador.block.model.BlockProfileEntity;
import com.capgemini.ccsw.estimador.blockdurationcalculator.enums.BlockEnums;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;
import com.capgemini.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;

@Service
public class BlockDurationCalculatorServiceImpl implements BlockDurationCalculatorService {

    private static final String DEVELOP_BLOCK_NAME = "Desarrollo";

    private static final int WORK_HOURS = 8;

    private static final int WORK_DAYS = 20;

    private static final double DEFAULT_DURATION = 0.0;

    @Autowired
    BlockService blockService;

    @Autowired
    BlockProfileService blockProfileService;

    @Override
    public List<BlockDurationTransformatedDto> getHoursGroupedByFte(BlockDurationCalculatorDto blockDurationCalculatorDto) {
        HashMap<String, Double> blockFteList = new HashMap<>();
        Map<String, List<String>> blockProfile = new HashMap<>();

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
        List<BlockDurationTransformatedDto> outputList = createBlocksFromCriteria(blockDurationCalculatorDto, blockEntityList);

        outputList.stream().forEach(block -> block.setDuration(calculateDuration(blockFteList, block)));

        return outputList;
    }

    private double calculateDuration(HashMap<String, Double> blockFteList, BlockDurationTransformatedDto block) {

        Double ftes = blockFteList.get(block.getBlockName());

        if (blockFteList == null || ftes == null || ftes.equals(0.0d))
            return DEFAULT_DURATION;

        return block.getHours() / WORK_DAYS / WORK_HOURS / ftes;
    }

    private List<BlockDurationTransformatedDto> createBlocksFromCriteria(BlockDurationCalculatorDto blockDurationCalculatorDto, List<BlockEntity> blockEntityList) {
        HashMap<String, List<CriteriaCalculationTransformationDto>> criteriaHashMap = new HashMap<>();

        List<CriteriaCalculationTransformationDto> criteriaList = blockDurationCalculatorDto.getCriteriaList();

        addDevelopEffortToCriteriaList(criteriaList, blockDurationCalculatorDto.getHours());

        for (CriteriaCalculationTransformationDto criteriaCalculationTransformation : criteriaList) {

            String blockName = criteriaCalculationTransformation.getBlock().getName();

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

    private void addDevelopEffortToCriteriaList(List<CriteriaCalculationTransformationDto> criteriaList, Double hours) {
        CriteriaCalculationTransformationDto dto = new CriteriaCalculationTransformationDto();
        criteriaList.add(dto);

        BlockDto block = new BlockDto();
        block.setName(DEVELOP_BLOCK_NAME);

        dto.setHours(hours);
        dto.setBlock(block);
    }

    @Override
    public Double projectTotalDuration(List<BlockDurationTransformatedDto> dto) {

        Map<String, Double> map = dto.stream().peek(elem -> elem.setDuration(elem.getDuration() * BlockEnums.valueOfLabel(elem.getBlockName()).weight)) //
                .collect(groupingBy(elem -> BlockEnums.valueOfLabel(elem.getBlockName()).type, summingDouble(BlockDurationTransformatedDto::getDuration)));

        Double common = map.getOrDefault("COMMON", DEFAULT_DURATION);
        Double architecture = map.getOrDefault("ARCHITECTURE", DEFAULT_DURATION);
        Double analysis = map.getOrDefault("ANALYSIS", DEFAULT_DURATION);
        Double ux = map.getOrDefault("UX", DEFAULT_DURATION);

        return common + Math.max(Math.max(architecture, analysis), ux);
    }

}
