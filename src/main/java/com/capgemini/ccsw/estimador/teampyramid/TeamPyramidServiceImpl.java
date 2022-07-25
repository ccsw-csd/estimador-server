package com.capgemini.ccsw.estimador.teampyramid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEditDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.profile.ProfileService;
import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidDto;
import com.capgemini.ccsw.estimador.teampyramid.model.TeamPyramidEntity;

/**
 * @author asolerpa
 *
 *         Clase que implementa los métodos de la interfaz TeamPyramidService
 *
 */
@Service
public class TeamPyramidServiceImpl implements TeamPyramidService {

    @Autowired
    TeamPyramidRepository teamPyramidRepository;

    @Autowired
    ProfileService profileService;

    @Override
    public List<TeamPyramidEntity> findByEstimationId(Long id) {

        return this.teamPyramidRepository.findByEstimationId(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEstimation(EstimationEntity estimation, EstimationEditDto data) {
        List<TeamPyramidEntity> actualTeamPyramid = findByEstimationId(estimation.getId());

        removeTasks(actualTeamPyramid, data.getTeamPyramid());
        addOrModifyTasks(actualTeamPyramid, data.getTeamPyramid(), estimation);

    }

    private void addOrModifyTasks(List<TeamPyramidEntity> actualTeamPyramids, List<TeamPyramidDto> teamPyramids, EstimationEntity estimation) {

        for (int order = 0; order < teamPyramids.size(); order++) {

            TeamPyramidDto teamPyramid = teamPyramids.get(order);
            TeamPyramidEntity item;

            if (teamPyramid.getId() != null) {
                item = actualTeamPyramids.stream().filter(e -> e.getId().equals(teamPyramid.getId())).findFirst().orElse(null);
            } else {
                item = new TeamPyramidEntity();
                item.setEstimation(estimation);
            }

            item.setProfile(profileService.get(teamPyramid.getProfile().getId()));
            item.setFte(teamPyramid.getFte());

            teamPyramidRepository.save(item);
        }

    }

    private void removeTasks(List<TeamPyramidEntity> actualTeamPyramids, List<TeamPyramidDto> teamPyramids) {

        for (TeamPyramidEntity teamPyramid : actualTeamPyramids) {
            TeamPyramidDto searchItem = teamPyramids.stream().filter(e -> teamPyramid.getId().equals(e.getId())).findFirst().orElse(null);

            if (searchItem == null) {
                teamPyramidRepository.delete(teamPyramid);
            }
        }

    }

}
