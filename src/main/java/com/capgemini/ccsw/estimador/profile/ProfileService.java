package com.capgemini.ccsw.estimador.profile;

import java.util.List;

import com.capgemini.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author iciudade
 *
 */
public interface ProfileService {

    List<ProfileEntity> findAll();

}
