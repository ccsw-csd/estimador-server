package com.capgemini.ccsw.estimador.profile;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author danipalm
 */
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {

    List<ProfileEntity> findAll();

}
