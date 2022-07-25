package com.capgemini.ccsw.estimador.profile;

import java.util.List;

import com.capgemini.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author danipalm
 *
 */
public interface ProfileService {

    List<ProfileEntity> findAll();

    ProfileEntity get(Long id);

}
