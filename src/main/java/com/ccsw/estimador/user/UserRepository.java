package com.ccsw.estimador.user;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ccsw.estimador.user.model.UserEntity;

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

    @Query("select u from UserEntity u where concat(first_name, ' ', last_name, ' ', username) LIKE %:filter% order by first_name, last_name asc")
    List<UserEntity> findUsersLikeFilter(String filter, Pageable pageable);

}
