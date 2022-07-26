package com.ccsw.estimador.blockdurationcalculator;

import java.util.List;

import com.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;

public interface BlockDurationCalculatorService {

    List<BlockDurationTransformatedDto> getHoursGroupedByFte(BlockDurationCalculatorDto blockDurationCalculatorDto);

    Double projectTotalDuration(List<BlockDurationTransformatedDto> blockDurationTransformatedDto);
}
