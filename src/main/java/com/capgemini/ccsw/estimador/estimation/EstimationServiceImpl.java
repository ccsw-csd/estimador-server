package com.capgemini.ccsw.estimador.estimation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.estimador.collaborator.CollaboratorService;
import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.config.security.UserUtils;
import com.capgemini.ccsw.estimador.consideration.ConsiderationService;
import com.capgemini.ccsw.estimador.consideration.model.ConsiderationDto;
import com.capgemini.ccsw.estimador.cost.CostService;
import com.capgemini.ccsw.estimador.cost.model.CostDto;
import com.capgemini.ccsw.estimador.cost.model.CostEntity;
import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;
import com.capgemini.ccsw.estimador.distribution.DistributionService;
import com.capgemini.ccsw.estimador.distribution.model.DistributionDto;
import com.capgemini.ccsw.estimador.elementweight.ElementWeightService;
import com.capgemini.ccsw.estimador.elementweight.model.ElementWeightDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationSearchDto;
import com.capgemini.ccsw.estimador.parameter.ParameterService;
import com.capgemini.ccsw.estimador.parameter.model.ParameterDto;
import com.capgemini.ccsw.estimador.taskarchitecture.TaskArchitectureService;
import com.capgemini.ccsw.estimador.taskarchitecture.model.TaskArchitectureDto;
import com.capgemini.ccsw.estimador.taskdevelopmenthours.TaskDevelopmentHoursService;
import com.capgemini.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursDto;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.TaskDevelopmentWeightsService;
import com.capgemini.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsDto;
import com.capgemini.ccsw.estimador.teampyramid.TeamPyramidService;
import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidDto;
import com.capgemini.ccsw.estimador.user.UserService;
import com.capgemini.ccsw.estimador.user.model.UserDto;

/**
 * @author iciudade
 */
@Service
public class EstimationServiceImpl implements EstimationService {

    @Autowired
    EstimationRepository estimationRepository;

    @Autowired
    UserService userService;

    @Autowired
    CollaboratorService collaboratorService;

    @Autowired
    ElementWeightService elementWeightService;

    @Autowired
    ParameterService parameterService;

    @Autowired
    TaskArchitectureService taskArchitectureService;

    @Autowired
    TaskDevelopmentHoursService taskDevelopmentHoursService;

    @Autowired
    TaskDevelopmentWeightsService taskDevelopmentWeightsService;

    @Autowired
    ConsiderationService considerationService;

    @Autowired
    CostService costService;

    @Autowired
    DistributionService distributionService;

    @Autowired
    TeamPyramidService teamPyramidService;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public Page<EstimationEntity> findPage(EstimationSearchDto dto) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate;

        Date endDate;

        try {
            if (dto.getStartDate() == null)
                startDate = format.parse("2020-01-01");
            else
                startDate = dto.getStartDate();

            if (dto.getEndDate() == null)
                endDate = format.parse("2099-12-31");
            else
                endDate = dto.getEndDate();
        } catch (ParseException e) {
            e.printStackTrace();
            startDate = null;
            endDate = null;
        }

        return this.estimationRepository.find(dto.getCustomerId(), dto.getProjectName(), startDate, endDate, dto.getPageable());
    }

    @Override
    @Transactional(readOnly = false)
    public Long saveEstimation(Long id, EstimationEditDto data) {

        EstimationEntity estimation = null;

        if (id == null) {
            estimation = new EstimationEntity();
            estimation.setCreated(new Date());
            estimation.setCreatedBy(userService.getByUsername(UserUtils.getUserDetails().getUsername()));
        } else {
            estimation = this.estimationRepository.findById(id).orElse(null);
        }

        estimation.setLastUpdate(new Date());
        estimation.setTotalDays(data.getTotalDays());
        estimation.setTotalCost(data.getTotalCost());
        estimation.setShowhours(data.getShowhours());

        estimationRepository.save(estimation);

        collaboratorService.saveEstimation(estimation, data);
        parameterService.saveEstimation(estimation, data);
        elementWeightService.saveEstimation(estimation, data);

        taskArchitectureService.saveEstimation(estimation, data);
        taskDevelopmentHoursService.saveEstimation(estimation, data);
        taskDevelopmentWeightsService.saveEstimation(estimation, data);
        considerationService.saveEstimation(estimation, data);

        //TODO: Resumen
        //distributionService.saveEstimation(estimation, data);
        //costService.saveEstimation(estimation, data);
        //teamPyramidService.saveEstimation(estimation, data);

        return estimation.getId();
    }

    @Override
    public EstimationEditDto getEstimationForEdit(Long id) {
        EstimationEntity estimation = this.estimationRepository.findById(id).orElse(null);
        if (estimation == null)
            return null;

        EstimationEditDto estimationDto = this.beanMapper.map(estimation, EstimationEditDto.class);

        estimationDto.setCollaborators(this.beanMapper.mapList(this.collaboratorService.findByEstimationId(id).stream().map(item -> item.getCollaborator()).collect(Collectors.toList()), UserDto.class));
        estimationDto.setParameters(this.beanMapper.mapList(this.parameterService.findParametersByEstimationId(id), ParameterDto.class));
        estimationDto.setElementWeight(this.beanMapper.mapList(this.elementWeightService.findByEstimationId(id), ElementWeightDto.class));

        estimationDto.setArchitectureTasks(this.beanMapper.mapList(this.taskArchitectureService.findByEstimationId(id), TaskArchitectureDto.class));
        estimationDto.setDevelopmentTasksHours(this.beanMapper.mapList(this.taskDevelopmentHoursService.findByEstimationId(id), TaskDevelopmentHoursDto.class));
        estimationDto.setDevelopmentTasksWeights(this.beanMapper.mapList(this.taskDevelopmentWeightsService.findByEstimationId(id), TaskDevelopmentWeightsDto.class));
        estimationDto.setConsiderations(this.beanMapper.mapList(this.considerationService.findByEstimationId(id), ConsiderationDto.class));

        estimationDto.setDistribution(this.beanMapper.mapList(this.distributionService.findByEstimationId(id), DistributionDto.class));
        estimationDto.setCosts(convertToList(costService.getByEstimationId(id)));
        estimationDto.setTeamPyramid(this.beanMapper.mapList(this.teamPyramidService.findByEstimationId(id), TeamPyramidDto.class));

        return estimationDto;
    }

    private List<CostDto> convertToList(CostEntity costEntity) {
        List<CostDto> costs = new ArrayList<>();

        if (costEntity == null)
            return costs;

        costs.add(new CostDto("A", costEntity.getCostGradeA(), costEntity.getMarginGradeA()));
        costs.add(new CostDto("B", costEntity.getCostGradeB(), costEntity.getMarginGradeB()));
        costs.add(new CostDto("C", costEntity.getCostGradeC(), costEntity.getMarginGradeC()));
        costs.add(new CostDto("D", costEntity.getCostGradeD(), costEntity.getMarginGradeD()));

        return costs;
    }

    @Override
    public List<EstimationEntity> findVersion(Long projectId) {

        return this.estimationRepository.findByProjectIdOrderByLastUpdateDesc(projectId);
    }

    @Override
    public EstimationEntity getLastEstimationByCustomer(CustomerDto customer) {

        return this.estimationRepository.findFirstByProjectCustomerOrderByLastUpdateDesc(this.beanMapper.map(customer, CustomerEntity.class));
    }

}
