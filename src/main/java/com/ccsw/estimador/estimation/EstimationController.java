package com.ccsw.estimador.estimation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.config.mapper.BeanMapper;
import com.ccsw.estimador.estimation.model.EstimationDto;
import com.ccsw.estimador.estimation.model.EstimationDuplicateDto;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationSearchDto;

/**
 * @author iciudade
 */
@RequestMapping(value = "/estimation")
@RestController
public class EstimationController {

    @Autowired
    EstimationService estimationService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "/{id}/duplicate", method = RequestMethod.PUT)
    public EstimationEditDto duplicateEstimation(@PathVariable Long id, @RequestBody EstimationDuplicateDto dto) {

        return this.estimationService.duplicateEstimation(id, dto.getVersion());
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<EstimationDto> findPage(@RequestBody EstimationSearchDto dto) {

        return this.beanMapper.mapPage(this.estimationService.findPage(dto), EstimationDto.class);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public EstimationEditDto getEstimation(@PathVariable Long id) {

        return this.estimationService.getEstimationForEdit(id);
    }

    @RequestMapping(path = { "/new", "/{id}" }, method = RequestMethod.POST)
    public Long saveEstimation(@PathVariable(required = false, name = "id") Long id, @RequestBody EstimationEditDto data) {

        return this.estimationService.saveEstimation(id, data);
    }

    @RequestMapping(path = "/version/{projectId}", method = RequestMethod.GET)
    public List<EstimationDto> findVersion(@PathVariable Long projectId) {

        return this.beanMapper.mapList(this.estimationService.findVersion(projectId), EstimationDto.class);
    }
    @RequestMapping(path = { "/export" }, method = RequestMethod.POST)
    public ResponseEntity<Resource> saveExport(@RequestBody EstimationEditDto data) throws FileNotFoundException {

        File file = this.estimationService.toExport(data);
        
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(resource);
    }
}