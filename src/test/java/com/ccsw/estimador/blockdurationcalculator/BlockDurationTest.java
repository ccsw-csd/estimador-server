package com.ccsw.estimador.blockdurationcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ccsw.estimador.block.BlockProfileService;
import com.ccsw.estimador.block.BlockService;
import com.ccsw.estimador.block.model.BlockDto;
import com.ccsw.estimador.block.model.BlockEntity;
import com.ccsw.estimador.block.model.BlockProfileEntity;
import com.ccsw.estimador.blockdurationcalculator.BlockDurationCalculatorServiceImpl;
import com.ccsw.estimador.blockdurationcalculator.model.BlockDurationCalculatorDto;
import com.ccsw.estimador.blockdurationcalculator.model.BlockDurationTransformatedDto;
import com.ccsw.estimador.blockdurationcalculator.model.FteDto;
import com.ccsw.estimador.criteriacalculation.model.CriteriaCalculationTransformationDto;
import com.ccsw.estimador.profile.model.ProfileEntity;

@ExtendWith(MockitoExtension.class)
public class BlockDurationTest {

    final Double totalHours = 10d;

    final String fteName = "P1";
    final Double fteNumber = 1d;

    final Long idBlock = 1l;
    final String blockName = "B1";
    final Double criteriaHours = 10d;

    final String profileName = "P1";

    @InjectMocks
    BlockDurationCalculatorServiceImpl blockDurationCalculatorServiceImpl;

    @Mock
    BlockService blockService;

    @Mock
    BlockProfileService blockProfileService;

    @Test
    void blockDurationCalculatorWorksCorrectlyTest() {

        List<BlockEntity> listBlock = new ArrayList<>();
        BlockEntity blockTest = mock(BlockEntity.class);
        when(blockTest.getName()).thenReturn(blockName);
        listBlock.add(blockTest);

        when(blockService.findAll()).thenReturn(listBlock);

        List<BlockProfileEntity> listBlockProfile = new ArrayList<>();
        BlockProfileEntity blockProfileTest = mock(BlockProfileEntity.class);
        when(blockProfileTest.getBlock()).thenReturn(blockTest);

        ProfileEntity profileTest = mock(ProfileEntity.class);
        when(profileTest.getName()).thenReturn(profileName);
        when(blockProfileTest.getProfile()).thenReturn(profileTest);
        listBlockProfile.add(blockProfileTest);

        when(blockProfileService.findAll()).thenReturn(listBlockProfile);

        BlockDurationCalculatorDto blockDurationCalculatorDto = mock(BlockDurationCalculatorDto.class);

        List<FteDto> fteList = new ArrayList<>();
        FteDto fteDto = mock(FteDto.class);
        when(fteDto.getName()).thenReturn(fteName);
        when(fteDto.getPersonNumber()).thenReturn(fteNumber);
        fteList.add(fteDto);

        List<CriteriaCalculationTransformationDto> criteriaList = new ArrayList<>();
        CriteriaCalculationTransformationDto criteriaDto = mock(CriteriaCalculationTransformationDto.class);
        BlockDto block = mock(BlockDto.class);
        when(block.getName()).thenReturn(blockName);
        when(criteriaDto.getBlock()).thenReturn(block);
        when(criteriaDto.getHours()).thenReturn(criteriaHours);
        criteriaList.add(criteriaDto);

        when(blockDurationCalculatorDto.getCriteriaList()).thenReturn(criteriaList);
        when(blockDurationCalculatorDto.getHours()).thenReturn(totalHours);
        when(blockDurationCalculatorDto.getFteList()).thenReturn(fteList);

        List<BlockDurationTransformatedDto> resultList = this.blockDurationCalculatorServiceImpl.getHoursGroupedByFte(blockDurationCalculatorDto);

        assertNotNull(resultList);
        assertEquals(0.0625, resultList.get(resultList.size() - 1).getDuration());
    }

    @Test
    void projectTotalDurationWorksCorrectlyTest() {
        List<BlockDurationTransformatedDto> blockDurationTransformatedDto = new ArrayList();
        BlockDurationTransformatedDto blockDto = mock(BlockDurationTransformatedDto.class);
        when(blockDto.getBlockName()).thenReturn("Desarrollo");
        when(blockDto.getDuration()).thenReturn(0.0625d);
        blockDurationTransformatedDto.add(blockDto);
        Double calculation = this.blockDurationCalculatorServiceImpl.projectTotalDuration(blockDurationTransformatedDto);

        assertEquals(0.0625d, calculation);

    }

}
