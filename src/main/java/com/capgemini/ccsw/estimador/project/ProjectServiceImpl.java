package com.capgemini.ccsw.estimador.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.project.model.ProjectEntity;

/**
 * @author iciudade
 */
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<ProjectEntity> findAll() {
		return this.projectRepository.findAll();
	}
	
}
