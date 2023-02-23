package com.ccsw.estimador.estimation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

    @Override
    public File toExport(EstimationEditDto dto) throws FileNotFoundException{
        Workbook workbook = new XSSFWorkbook();

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        int columna = 0;
        Sheet sheet = workbook.createSheet("Tareas");
        sheet.setColumnWidth(0, 7500);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 4000);

        createFirstSheet(sheet, headerStyle, workbook, dto, columna);

        sheet = workbook.createSheet("Resumen");
        sheet.setColumnWidth(0, 9000);
        sheet.setColumnWidth(1, 4500);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 4000);
        
        createSecondSheet(sheet, headerStyle, workbook, dto, columna);

        try {
            // Write the workbook in file system
            File file = File.createTempFile("Resumen" , "xlsx");
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createSecondSheet(Sheet sheet, CellStyle headerStyle, Workbook workbook, EstimationEditDto dto, int columna) {

        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(columna);
        
        createDistributionTable(workbook, headerCell, headerStyle, sheet, dto, columna);
        createMemberTable(workbook, headerCell, headerStyle, sheet, dto, columna);
        createRevenueTable(workbook, headerCell, headerStyle, sheet, dto, columna);
        createConceptTable(workbook, headerCell, headerStyle, sheet, dto, columna);


    }

    private void createConceptTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet,
            EstimationEditDto dto, int columna) {

        int fila = 8 + dto.getDistribution().size() + dto.getTeamPyramid().size() + dto.getCosts().size();         

        fila ++;
        Row row = sheet.createRow(fila);
        Cell cell = row.createCell(columna);
        cell.setCellValue("Conceptos");
        cell.setCellStyle(headerStyle);
        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Concepto");
        cell = row.createCell(columna + 1);
        cell.setCellValue("Valor");
        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Jornadas");
        cell = row.createCell(columna + 1);
        cell.setCellValue(dto.getTotalDays());
        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Revenue (€)");
        cell = row.createCell(columna + 1);
        cell.setCellValue(dto.getTotalCost());
        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Equipo total");
        cell = row.createCell(columna + 1);
        fila ++;
        int trabajadores = 0;
        List<TeamPyramidDto> perfiles = dto.getTeamPyramid();
        for (TeamPyramidDto perfil : perfiles) {
            if(perfil.getFte() != 0){
                trabajadores += perfil.getFte();
            }
        }
        cell.setCellValue(trabajadores);
    }

    private void createRevenueTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet,
            EstimationEditDto dto, int columna) {

        int fila = 5 + dto.getDistribution().size() + dto.getTeamPyramid().size();
        fila ++;
        Row row = sheet.createRow(fila);
        Cell cell = row.createCell(columna);
        cell.setCellValue("Revenue");
        cell.setCellStyle(headerStyle);
        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Grado");
        cell = row.createCell(columna + 1);
        cell.setCellValue("Jornadas");
        cell = row.createCell(columna + 2);
        cell.setCellValue("Coste (€)");
        cell = row.createCell(columna + 3);
        cell.setCellValue("Margen (%)");
        cell = row.createCell(columna + 4);
        cell.setCellValue("Revenue");
        fila ++;

        List<CostDto> costes = dto.getCosts();
        for(CostDto coste : costes){
            row = sheet.createRow(fila);
            cell = row.createCell(columna);
            cell.setCellValue(coste.getGrade());
            cell = row.createCell(columna + 1);
            cell.setCellValue(coste.getWorkdays());
            cell = row.createCell(columna + 2);
            cell.setCellValue(coste.getCost());
            cell = row.createCell(columna + 3);
            cell.setCellValue(coste.getMargin());
            cell = row.createCell(columna + 4);
            cell.setCellValue(coste.getRevenue());
            fila ++;
        }
    }

    private void createMemberTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet,
            EstimationEditDto dto, int columna) {
        
        int fila = 2 + dto.getDistribution().size();
        Row row = sheet.createRow(fila);
        Cell cell = row.createCell(columna);

        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Miembros del equipo");
        cell.setCellStyle(headerStyle);
        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Perfil");
        cell = row.createCell(columna + 1);
        cell.setCellValue("FTE's");
        fila ++;

        List<TeamPyramidDto> perfiles = dto.getTeamPyramid();
        for (TeamPyramidDto perfil : perfiles) {
            row = sheet.createRow(fila);
            cell = row.createCell(columna);
            cell.setCellValue(perfil.getProfile().getName());
            cell = row.createCell(columna + 1);
            cell.setCellValue(perfil.getFte());
            fila++;
        }
    }

    private void createDistributionTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet,
            EstimationEditDto dto, int columna) {

        headerCell.setCellValue("Distribución del equipo");
        headerCell.setCellStyle(headerStyle);
                        
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
                        
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(columna);
        cell.setCellValue("Equipo");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 1);
        cell.setCellValue("Jornadas totales");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 2);
        cell.setCellValue("A (%)");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 3);
        cell.setCellValue("B (%)");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 4);
        cell.setCellValue("C (%)");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 5);
        cell.setCellValue("D (%)");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 6);
        cell.setCellValue("TOTAL (%)");
        cell.setCellStyle(style);

        List<DistributionDto> distribuciones = dto.getDistribution();
        int fila = 2;

        for(DistributionDto distribucion : distribuciones){
            row = sheet.createRow(fila);
            cell = row.createCell(columna);
            cell.setCellValue(distribucion.getBlock().getName());
            cell = row.createCell(columna + 1);
            cell.setCellValue(distribucion.getWorkdays());
            cell = row.createCell(columna + 2);
            cell.setCellValue(distribucion.getGradeA());
            cell = row.createCell(columna + 3);
            cell.setCellValue(distribucion.getGradeB());
            cell = row.createCell(columna + 4);
            cell.setCellValue(distribucion.getGradeC());
            cell = row.createCell(columna + 5);
            cell.setCellValue(distribucion.getGradeD());
            cell = row.createCell(columna + 6);
            cell.setCellValue(distribucion.getTotal());           
            fila ++;
        }

    }

    private void createFirstSheet(Sheet sheet, CellStyle headerStyle, Workbook workbook, EstimationEditDto dto, int columna) {
        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(columna);
        
        createArchitectureTable(workbook, headerCell, headerStyle, sheet, dto, columna);
        createTaskDevelopmentHoursTable(workbook, headerCell, headerStyle, sheet, dto, columna);
        createCommentaryTable(workbook, headerCell, headerStyle, sheet, dto, columna);
        
    }

    private void createCommentaryTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet,
            EstimationEditDto dto, int columna) {

        int fila = 5 + dto.getArchitectureTasks().size() + dto.getDevelopmentTasksHours().size();
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
               
        fila ++;
        Row row = sheet.createRow(fila);
        Cell cell = row.createCell(columna);
        cell.setCellValue("Consideraciones");
        cell.setCellStyle(headerStyle);

        fila++;
        List<ConsiderationDto> comentarios = dto.getConsiderations();
        for(ConsiderationDto comentario : comentarios) {
            row = sheet.createRow(fila);
            cell = row.createCell(columna);
            cell.setCellValue(comentario.getComment());  
            fila++;      
        }
    }

    private void createTaskDevelopmentHoursTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet,
            EstimationEditDto dto, int columna) {

        int fila = 2 + dto.getArchitectureTasks().size();

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        
        fila ++;
        Row row = sheet.createRow(fila);
        Cell cell = row.createCell(columna);
        cell.setCellValue("Desarrollo");
        cell.setCellStyle(headerStyle);

        fila ++;
        row = sheet.createRow(fila);
        cell = row.createCell(columna);
        cell.setCellValue("Tareas");
        cell.setCellStyle(style);
        cell = row.createCell(columna + 1);
        cell.setCellValue("Horas");
        cell.setCellStyle(style);
        
        fila ++;
        List<TaskDevelopmentHoursDto> desarrollos = dto.getDevelopmentTasksHours();
        for(TaskDevelopmentHoursDto desarrollo: desarrollos){
            row = sheet.createRow(fila);
            cell = row.createCell(columna);
            cell.setCellValue(desarrollo.getName());
            cell = row.createCell(columna + 1);
            cell.setCellValue(desarrollo.getHours());
            fila++;
        }
    }

    private void createArchitectureTable(Workbook workbook, Cell headerCell, CellStyle headerStyle, Sheet sheet, EstimationEditDto dto, int columna) {
        headerCell.setCellValue("Arquitectura");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(columna);
        cell.setCellValue("Tareas");
        cell.setCellStyle(style);
        cell = row.createCell(columna);
        cell.setCellValue("Horas");
        cell.setCellStyle(style);
        style = workbook.createCellStyle();
        style.setWrapText(true);

        List<TaskArchitectureDto> tareas = dto.getArchitectureTasks();
        int fila = 2;
        for (TaskArchitectureDto tarea : tareas) {
            row = sheet.createRow(fila);
            cell = row.createCell(columna);
            cell.setCellValue(tarea.getName());
            cell = row.createCell(columna + 1);
            cell.setCellValue(tarea.getHours());
            fila++;
        }
    }

}
