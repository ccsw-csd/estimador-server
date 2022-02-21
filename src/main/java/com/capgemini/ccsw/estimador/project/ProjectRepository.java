package com.capgemini.ccsw.estimador.project;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.project.model.ProjectEntity;

/**
 * @author iciudade
 */
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long>{

}
