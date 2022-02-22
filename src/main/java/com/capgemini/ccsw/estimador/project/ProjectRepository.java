package com.capgemini.ccsw.estimador.project;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.project.model.ProjectEntity;

/**
 * @author iciudade
 */
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long>{

	/**
	 * Metodo para recuperar un listado de {@link com.capgemini.ccsw.estimador.project.model.ProjectEntity}
	 * @return
	 */
	List<ProjectEntity> findAll();
}
