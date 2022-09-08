package com.ccsw.estimador.user;

import java.util.List;

import com.ccsw.estimador.config.security.UserInfoDto;
import com.ccsw.estimador.user.model.UserEntity;

/**
 * @author pajimene
 *
 */
public interface UserService {

    /**
     * Recupera un usuario con su username
     *
     * @param username
     * @return
     * @throws Exception
     */
    UserEntity getByUsername(String username);

    List<UserEntity> findByFilter(String filter);

    void createUser(UserInfoDto user);
}
