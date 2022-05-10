package com.capgemini.ccsw.estimador.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.profile.model.ProfileEntity;

/**
 * @author danipalm
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public List<ProfileEntity> findAll() {
        return this.profileRepository.findAll();
    }

}
