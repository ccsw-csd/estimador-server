package com.capgemini.ccsw.estimador.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.estimador.user.model.UserEntity;

/**
 * @author pajimene
 *
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * Recupera un usuario con su username
     *
     * @param username
     * @return
     * @throws Exception
     */
    UserEntity getByUsername(String username);

    @Query(value = "select * from user where concat(first_name, ' ', last_name, ' ', username) LIKE %:name% LIMIT 15", nativeQuery = true)
    List<UserEntity> findByFilter(@Param("name") String filter);

}
