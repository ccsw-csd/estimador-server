package com.capgemini.ccsw.estimador.user;

import com.capgemini.ccsw.estimador.user.model.UserEntity;

/**
 * @author pajimene
 *
 */
public interface UserService {

  /**
   * Recupera un usuario con su username
   * @param username
   * @return
   * @throws Exception
   */
  UserEntity getByUsername(String username);
}
