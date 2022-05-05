package com.capgemini.ccsw.estimador.profile;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author iciudade
 */
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {

    List<ProfileEntity> findAll();

}
