package com.ccsw.estimador.user;

import java.util.List;

import com.ccsw.estimador.config.security.UserInfoAppDto;
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

    /**
     * Guarda un usuario
     *
     * @param dto
     */
    void save(UserInfoAppDto dto);
}