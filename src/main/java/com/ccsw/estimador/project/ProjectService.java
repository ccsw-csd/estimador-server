package com.ccsw.estimador.project;

import java.util.List;

import com.ccsw.estimador.project.model.ProjectDto;
import com.ccsw.estimador.project.model.ProjectEntity;
import com.ccsw.estimador.user.model.UserEntity;

/**
 * @author iciudade
 */
public interface ProjectService {

    /**
     * Metodo para recuperar un listado de {@link com.ccsw.estimador.project.model.ProjectEntity}
     * @return
     */
    List<ProjectEntity> findAll();

    ProjectEntity createProject(ProjectDto data, UserEntity userEntity);

    ProjectEntity get(Long id);
}
