package com.ccsw.estimador.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.estimador.profile.model.ProfileEntity;

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

    @Override
    public ProfileEntity get(Long id) {
        return this.profileRepository.findById(id).orElse(null);
    }

}
