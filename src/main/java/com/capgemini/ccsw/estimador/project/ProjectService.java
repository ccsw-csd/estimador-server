package com.capgemini.ccsw.estimador.project;

import java.util.List;

import com.capgemini.ccsw.estimador.project.model.ProjectEntity;

/**
 * @author iciudade
 */
public interface ProjectService {

	/**
	 * Metodo para recuperar un listado de {@link com.capgemini.ccsw.estimador.project.model.ProjectEntity}
	 * @return
	 */
	List<ProjectEntity> findAll();
}
