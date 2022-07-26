package com.ccsw.estimador.collaborator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.collaborator.model.CollaboratorEntity;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.user.UserService;
import com.ccsw.estimador.user.model.UserDto;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz CollaboratorService
 *
 */
@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    CollaboratorRepository collaboratorRepository;

    @Autowired
    UserService userService;

    @Override
    public List<CollaboratorEntity> findByEstimationId(Long id) {

        return this.collaboratorRepository.findByEstimationId(id);

    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {

        List<CollaboratorEntity> actualCollaborators = findByEstimationId(estimation.getId());

        removeCollaborators(actualCollaborators, data.getCollaborators());
        addCollaborators(estimation, actualCollaborators, data.getCollaborators());
    }

    private void addCollaborators(EstimationEntity estimation, List<CollaboratorEntity> actualCollaborators, List<UserDto> collaborators) {

        for (UserDto userData : collaborators) {
            if (usernameNotExistsInCollaboratorsDDBB(userData.getUsername(), actualCollaborators)) {

                CollaboratorEntity collaborator = new CollaboratorEntity();
                collaborator.setCollaborator(userService.getByUsername(userData.getUsername()));
                collaborator.setEstimation(estimation);
                collaboratorRepository.save(collaborator);
            }
        }
    }

    private void removeCollaborators(List<CollaboratorEntity> actualCollaborators, List<UserDto> collaborators) {
        for (CollaboratorEntity collaborator : actualCollaborators) {

            if (usernameNotExistsInCollaboratorsDto(collaborator.getCollaborator().getUsername(), collaborators)) {
                collaboratorRepository.delete(collaborator);
            }
        }
    }

    private boolean usernameNotExistsInCollaboratorsDDBB(String username, List<CollaboratorEntity> actualCollaborators) {
        return actualCollaborators.stream().filter(e -> e.getCollaborator().getUsername().equals(username)).findFirst().orElse(null) == null;
    }

    private boolean usernameNotExistsInCollaboratorsDto(String username, List<UserDto> userList) {
        return userList.stream().filter(e -> e.getUsername().equals(username)).findFirst().orElse(null) == null;
    }

}
