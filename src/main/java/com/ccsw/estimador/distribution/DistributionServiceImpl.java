package com.ccsw.estimador.distribution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.block.BlockService;
import com.ccsw.estimador.distribution.model.DistributionDto;
import com.ccsw.estimador.distribution.model.DistributionEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz SummaryService
 *
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    DistributionRepository distributionRepository;

    @Autowired
    BlockService blockService;

    @Override
    public List<DistributionEntity> findByEstimationId(Long id) {

        return this.distributionRepository.findByEstimationId(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {
        List<DistributionEntity> actualDistribution = findByEstimationId(estimation.getId());

        removeTasks(actualDistribution, data.getDistribution());
        addOrModifyTasks(actualDistribution, data.getDistribution(), estimation);

    }

    private void addOrModifyTasks(List<DistributionEntity> actualDistributions, List<DistributionDto> distributions, EstimationEntity estimation) {

        for (int order = 0; order < distributions.size(); order++) {

            DistributionDto distributionDto = distributions.get(order);
            DistributionEntity item;

            if (distributionDto.getId() != null) {
                item = actualDistributions.stream().filter(e -> e.getId().equals(distributionDto.getId())).findFirst().orElse(null);
            } else {
                item = new DistributionEntity();
                item.setEstimation(estimation);
            }

            item.setBlock(blockService.get(distributionDto.getBlock().getId()));
            item.setGradeA(distributionDto.getGradeA());
            item.setGradeB(distributionDto.getGradeB());
            item.setGradeC(distributionDto.getGradeC());
            item.setGradeD(distributionDto.getGradeD());

            distributionRepository.save(item);
        }

    }

    private void removeTasks(List<DistributionEntity> actualTasks, List<DistributionDto> tasks) {

        for (DistributionEntity task : actualTasks) {
            DistributionDto searchItem = tasks.stream().filter(e -> task.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                distributionRepository.delete(task);
            }
        }

    }

}
