package com.ccsw.estimador.profile;

import java.util.List;

import com.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author danipalm
 *
 */
public interface ProfileService {

    List<ProfileEntity> findAll();

    ProfileEntity get(Long id);

}
