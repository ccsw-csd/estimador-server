package com.capgemini.ccsw.estimador.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ccsw.estimador.profile.ProfileRepository;
import com.ccsw.estimador.profile.ProfileServiceImpl;
import com.ccsw.estimador.profile.model.ProfileEntity;

@ExtendWith(MockitoExtension.class)
public class ProfileTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Test
    public void findAllShouldReturnAllProfiles() {

        List<ProfileEntity> list = new ArrayList<>();
        list.add(mock(ProfileEntity.class));

        when(profileRepository.findAll()).thenReturn(list);

        List<ProfileEntity> profiles = profileService.findAll();
        assertNotNull(profiles);
        assertEquals(1, profiles.size());
    }
}
