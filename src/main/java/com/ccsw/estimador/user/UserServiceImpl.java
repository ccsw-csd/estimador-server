package com.ccsw.estimador.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccsw.estimador.config.security.UserInfoDto;
import com.ccsw.estimador.role.RoleRepository;
import com.ccsw.estimador.user.model.UserEntity;

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

    @Override
    public List<UserEntity> findByFilter(String filter) {

        return this.userRepository.findUsersLikeFilter(filter, PageRequest.of(0, 15));
    }

    @Override
    public void createUser(UserInfoDto dto) {
        if (getByUsername(dto.getUsername()) != null)
            return;

        UserEntity user = new UserEntity();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getMail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        this.userRepository.save(user);

    }

}
