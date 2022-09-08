package com.ccsw.estimador.estimation;

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

import com.ccsw.estimador.collaborator.CollaboratorService;
import com.ccsw.estimador.config.mapper.BeanMapper;
import com.ccsw.estimador.config.security.UserUtils;
import com.ccsw.estimador.consideration.ConsiderationService;
import com.ccsw.estimador.consideration.model.ConsiderationDto;
import com.ccsw.estimador.cost.CostService;
import com.ccsw.estimador.cost.model.CostDto;
import com.ccsw.estimador.cost.model.CostEntity;
import com.ccsw.estimador.criteriacalculation.CriteriaCalculationService;
import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.customer.model.CustomerEntity;
import com.ccsw.estimador.distribution.DistributionService;
import com.ccsw.estimador.distribution.model.DistributionDto;
import com.ccsw.estimador.elementweight.ElementWeightService;
import com.ccsw.estimador.elementweight.model.ElementWeightDto;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.estimation.model.EstimationSearchDto;
import com.ccsw.estimador.parameter.ParameterService;
import com.ccsw.estimador.parameter.model.ParameterDto;
import com.ccsw.estimador.project.ProjectService;
import com.ccsw.estimador.project.model.ProjectDto;
import com.ccsw.estimador.project.model.ProjectEntity;
import com.ccsw.estimador.taskarchitecture.TaskArchitectureService;
import com.ccsw.estimador.taskarchitecture.model.TaskArchitectureDto;
import com.ccsw.estimador.taskdevelopmenthours.TaskDevelopmentHoursService;
import com.ccsw.estimador.taskdevelopmenthours.model.TaskDevelopmentHoursDto;
import com.ccsw.estimador.taskdevelopmentweights.TaskDevelopmentWeightsService;
import com.ccsw.estimador.taskdevelopmentweights.model.TaskDevelopmentWeightsDto;
import com.ccsw.estimador.teampyramid.TeamPyramidService;
import com.ccsw.estimador.teampyramid.model.TeamPyramidDto;
import com.ccsw.estimador.user.UserService;
import com.ccsw.estimador.user.model.UserDto;
import com.ccsw.estimador.user.model.UserEntity;

import io.jsonwebtoken.lang.Collections;

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
    ProjectService projectService;

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

    @Autowired
    CriteriaCalculationService criteriaCalculationService;

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

        String username = UserUtils.getUserDetails().getUsername();

        if (dto.getAdminView() && UserUtils.hasRole("ADMIN")) {
            username = null;
        }

        return this.estimationRepository.find(dto.getCustomerId(), dto.getProjectName(), startDate, endDate, username, dto.getPageable());
    }

    @Override
    @Transactional(readOnly = false)
    public Long saveEstimation(Long id, EstimationEditDto data) {

        EstimationEntity estimation = null;

        if (id == null) {

            UserEntity userEntity = userService.getByUsername(UserUtils.getUserDetails().getUsername());

            estimation = new EstimationEntity();
            estimation.setCreated(new Date());
            estimation.setCreatedBy(userEntity);
            estimation.setEstVersion(data.getEstVersion());

            ProjectEntity project = null;

            if (data.getProject().getId() == null) {
                project = projectService.createProject(data.getProject(), userEntity);
            } else {
                project = projectService.get(data.getProject().getId());
            }

            estimation.setProject(project);

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

        distributionService.saveEstimation(estimation, data);
        costService.saveEstimation(estimation, data);
        teamPyramidService.saveEstimation(estimation, data);

        return estimation.getId();
    }

    @Override
    public EstimationEditDto getEstimationForEdit(Long id) {
        EstimationEntity estimation = this.estimationRepository.findById(id).orElse(null);

        if (estimation == null)
            return createNewEstimation();
        else
            return populateEstimation(id, estimation);
    }

    private EstimationEditDto createNewEstimation() {
        final Long defaultEstimationId = 1L;
        EstimationEditDto estimation = new EstimationEditDto();

        UserEntity user = userService.getByUsername(UserUtils.getUserDetails().getUsername());
        UserDto userDto = beanMapper.map(user, UserDto.class);

        estimation.setCreated(new Date());
        estimation.setEstVersion("0.1");

        estimation.setProject(new ProjectDto());
        estimation.getProject().setName("");

        estimation.setLastUpdate(new Date());
        estimation.setCreatedBy(userDto);
        estimation.setShowhours(true);

        estimation.setCollaborators(Collections.arrayToList(new UserDto[] { userDto }));

        estimation.setParameters(this.beanMapper.mapList(this.parameterService.findParametersByEstimationId(defaultEstimationId), ParameterDto.class));
        estimation.setElementWeight(this.beanMapper.mapList(this.elementWeightService.findByEstimationId(defaultEstimationId), ElementWeightDto.class));

        estimation.setArchitectureTasks(new ArrayList<>());
        estimation.setDevelopmentTasksHours(new ArrayList<>());
        estimation.setDevelopmentTasksWeights(new ArrayList<>());
        estimation.setConsiderations(new ArrayList<>());

        estimation.setDistribution(this.beanMapper.mapList(this.distributionService.findByEstimationId(defaultEstimationId), DistributionDto.class));
        estimation.setCosts(convertToList(costService.getByEstimationId(defaultEstimationId)));
        estimation.setTeamPyramid(this.beanMapper.mapList(this.teamPyramidService.findByEstimationId(defaultEstimationId), TeamPyramidDto.class));

        estimation.getParameters().forEach(i -> i.setId(null));
        estimation.getElementWeight().forEach(i -> i.setId(null));
        estimation.getDistribution().forEach(i -> i.setId(null));
        estimation.getTeamPyramid().forEach(i -> i.setId(null));

        return estimation;
    }

    private EstimationEditDto populateEstimation(Long id, EstimationEntity estimationEntity) {
        EstimationEditDto estimation = this.beanMapper.map(estimationEntity, EstimationEditDto.class);

        estimation.setCollaborators(this.beanMapper.mapList(this.collaboratorService.findByEstimationId(id).stream().map(item -> item.getCollaborator()).collect(Collectors.toList()), UserDto.class));
        estimation.setParameters(this.beanMapper.mapList(this.parameterService.findParametersByEstimationId(id), ParameterDto.class));
        estimation.setElementWeight(this.beanMapper.mapList(this.elementWeightService.findByEstimationId(id), ElementWeightDto.class));

        estimation.setArchitectureTasks(this.beanMapper.mapList(this.taskArchitectureService.findByEstimationId(id), TaskArchitectureDto.class));
        estimation.setDevelopmentTasksHours(this.beanMapper.mapList(this.taskDevelopmentHoursService.findByEstimationId(id), TaskDevelopmentHoursDto.class));
        estimation.setDevelopmentTasksWeights(this.beanMapper.mapList(this.taskDevelopmentWeightsService.findByEstimationId(id), TaskDevelopmentWeightsDto.class));
        estimation.setConsiderations(this.beanMapper.mapList(this.considerationService.findByEstimationId(id), ConsiderationDto.class));

        estimation.setDistribution(this.beanMapper.mapList(this.distributionService.findByEstimationId(id), DistributionDto.class));
        estimation.setCosts(convertToList(costService.getByEstimationId(id)));
        estimation.setTeamPyramid(this.beanMapper.mapList(this.teamPyramidService.findByEstimationId(id), TeamPyramidDto.class));

        return estimation;
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

    @Override
    public EstimationEditDto duplicateEstimation(Long id, String version) {

        EstimationEditDto data = getEstimationForEdit(id);

        UserEntity user = userService.getByUsername(UserUtils.getUserDetails().getUsername());
        UserDto userDto = beanMapper.map(user, UserDto.class);

        data.setId(null);
        data.setEstVersion(version);
        data.setCreated(new Date());
        data.setLastUpdate(new Date());
        data.setCreatedBy(userDto);

        data.getParameters().forEach(i -> i.setId(null));
        data.getElementWeight().forEach(i -> i.setId(i.getId() * -1));

        data.getArchitectureTasks().forEach(i -> i.setId(null));
        data.getDevelopmentTasksHours().forEach(i -> i.setId(null));
        data.getDevelopmentTasksWeights().forEach(i -> {
            i.setId(null);
            i.getWorkElementWeight().setId(i.getWorkElementWeight().getId() * -1);
        });
        data.getConsiderations().forEach(i -> i.setId(null));

        data.getDistribution().forEach(i -> i.setId(null));
        data.getTeamPyramid().forEach(i -> i.setId(null));

        Long newId = saveEstimation(null, data);
        data.setId(newId);

        return data;
    }

}
