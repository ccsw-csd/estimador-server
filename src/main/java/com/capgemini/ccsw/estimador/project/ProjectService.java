package com.capgemini.ccsw.estimador.project;

import java.util.List;

import com.capgemini.ccsw.estimador.project.model.ProjectDto;
import com.capgemini.ccsw.estimador.project.model.ProjectEntity;
import com.capgemini.ccsw.estimador.user.model.UserEntity;

/**
 * @author iciudade
 */
public interface ProjectService {

    /**
     * Metodo para recuperar un listado de {@link com.capgemini.ccsw.estimador.project.model.ProjectEntity}
     * @return
     */
    List<ProjectEntity> findAll();

    ProjectEntity createProject(ProjectDto data, UserEntity userEntity);
}
