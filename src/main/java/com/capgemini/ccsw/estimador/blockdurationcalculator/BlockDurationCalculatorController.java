package com.capgemini.ccsw.estimador.blockdurationcalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.capgemini.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;

@RestController
@RequestMapping(value = "/blockdurationcalculator")
public class BlockDurationCalculatorController {

    @Autowired
    BlockDurationCalculatorService blockDurationCalculatorService;

    @RequestMapping(path = "/calculate")
    public List<BlockDurationTransformatedDto> getHoursGroupedByFte(
            @RequestBody BlockDurationCalculatorDto blockDurationCalculatorDto) {

        return this.blockDurationCalculatorService.getHoursGroupedByFte(blockDurationCalculatorDto);
    }

    @RequestMapping(path = "/totalduration", method = RequestMethod.POST)
    public Double calculateTotalDuration(
            @RequestBody List<BlockDurationTransformatedDto> blockDurationTransformatedDto) {

        return this.blockDurationCalculatorService.projectTotalDuration(blockDurationTransformatedDto);
    }
}
