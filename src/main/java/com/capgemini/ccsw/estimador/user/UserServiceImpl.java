package com.capgemini.ccsw.estimador.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.estimador.config.security.UserInfoAppDto;
import com.capgemini.ccsw.estimador.role.RoleRepository;
import com.capgemini.ccsw.estimador.user.model.UserEntity;

/**
 * @author pajimene
 *
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserEntity getByUsername(String username) {

        return this.userRepository.getByUsername(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(UserInfoAppDto dto) {

        UserEntity user = new UserEntity();

        user.setRole(this.roleRepository.getByName(dto.getRole()));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getMail());
        user.setFirst_name(dto.getFirstName());
        user.setLast_name(dto.getLastName());

        this.userRepository.save(user);
    }

    @Override
    public List<UserEntity> findByFilter(String filter) {

        return this.userRepository.findByFilter(filter);
    }

}
