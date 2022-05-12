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

@Service
public class BlockDurationCalculatorServiceImpl implements BlockDurationCalculatorService {

    private static final String TOTAL_BLOCKNAME = "TOTAL DEVELOPMENT";

    private static final int WORK_HOURS = 8;

    private static final int WORK_DAYS = 20;

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
        BlockDurationTransformatedDto developer = new BlockDurationTransformatedDto();
        developer.setBlockName(TOTAL_BLOCKNAME);
        developer.setHours(blockDurationCalculatorDto.getHours());
        developer.setDuration(blockDurationCalculatorDto.getHours() / WORK_DAYS / WORK_HOURS / blockProfileEntityList.size());
        outputList.add(developer);
        return outputList;
    }

    private double calculateDuration(HashMap<String, Double> blockFteList, BlockDurationTransformatedDto block) {
        return block.getHours() / WORK_DAYS / WORK_HOURS / blockFteList.get(block.getBlockName());
    }

    private List<BlockDurationTransformatedDto> createBlocksFromCriteria(BlockDurationCalculatorDto blockDurationCalculatorDto, List<BlockEntity> blockEntityList) {
        HashMap<String, List<CriteriaCalculationTransformationDto>> criteriaHashMap = new HashMap<>();
        for (CriteriaCalculationTransformationDto criteriaCalculationTransformation : blockDurationCalculatorDto.getCriteriaList()) {

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

    public Double projectTotalDuration(List<BlockDurationTransformatedDto> blockDurationTransformatedDto) {
        Double calculation = 0.0;
        Double architeture = 0.0, analysis = 0.0, ux = 0.0;

        for (BlockDurationTransformatedDto block : blockDurationTransformatedDto) {
            switch (block.getBlockName()) {
            case "DEVELOPMENT":
                calculation += block.getDuration();
                break;
            case "TESTING":
                calculation += block.getDuration() * 0.5;
                break;
            case "DEPLOY":
                calculation += block.getDuration();
                break;
            case "DOCUMENTATION":
                calculation += block.getDuration() * 0.75;
                break;
            case "ARCHITECTURE":
                architeture += block.getDuration() * 0.5;
                break;
            case "ANALYSYS":
                analysis += block.getDuration() * 0.5;
                break;
            case "UX":
                ux += block.getDuration() * 0.5;
                break;
            default:
                break;
            }
        }
        calculation += Math.max(Math.max(architeture, analysis), ux);

        return calculation;

    }

}
