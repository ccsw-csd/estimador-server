package com.capgemini.ccsw.estimador.project;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.estimador.customer.CustomerService;
import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;
import com.capgemini.ccsw.estimador.project.model.ProjectDto;
import com.capgemini.ccsw.estimador.project.model.ProjectEntity;
import com.capgemini.ccsw.estimador.user.model.UserEntity;

/**
 * @author iciudade
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public List<ProjectEntity> findAll() {
        return this.projectRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public ProjectEntity createProject(ProjectDto data, UserEntity userEntity) {

        ProjectEntity project = new ProjectEntity();

        CustomerEntity customer = customerService.getOrNew(data.getCustomer());

        project.setCreated(new Date());
        project.setCreatedBy(userEntity);
        project.setCustomer(customer);
        project.setName(data.getName());

        projectRepository.save(project);

        return project;
    }

}
