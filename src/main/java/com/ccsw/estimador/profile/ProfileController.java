package com.ccsw.estimador.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.estimador.config.mapper.BeanMapper;
import com.ccsw.estimador.profile.model.ProfileDto;

/**
 * @author asolerpa
 *
 *         Controlador que expone las operaciones de negocio de la entidad
 *         Profile
 *
 */
@RequestMapping(value = "/profile")
@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ProfileDto> findAllProfiles() {

        return this.beanMapper.mapList(this.profileService.findAll(), ProfileDto.class);
    }

}
