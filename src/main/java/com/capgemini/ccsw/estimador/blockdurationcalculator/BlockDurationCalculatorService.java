package com.capgemini.ccsw.estimador.blockdurationcalculator;

import java.util.List;

import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;

public interface BlockDurationCalculatorService {

    List<BlockDurationTransformatedDto> getHoursGroupedByFte(BlockDurationCalculatorDto blockDurationCalculatorDto);

    Double projectTotalDuration(List<BlockDurationTransformatedDto> blockDurationTransformatedDto);
}
