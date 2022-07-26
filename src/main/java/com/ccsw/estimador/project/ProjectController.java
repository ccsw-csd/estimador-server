package com.ccsw.estimador.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.config.mapper.BeanMapper;
import com.ccsw.estimador.project.model.ProjectDto;

/**
 * 
 * @author iciudade
 *
 */
@RequestMapping(value = "/project/")
@RestController
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	BeanMapper beanMapper;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<ProjectDto> findAll(){
		return this.beanMapper.mapList(projectService.findAll(), ProjectDto.class);
	}


}
