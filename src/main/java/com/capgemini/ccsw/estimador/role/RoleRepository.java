package com.capgemini.ccsw.estimador.role;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.role.model.RoleEntity;

/**
 * @author iciudade
 */
public interface RoleRepository extends CrudRepository<RoleEntity, Long>{

	/**
	 * Recupera un role por su name
	 * @param name
	 * @return
	 */
	RoleEntity getByName(String name);
	
	/**
	 * Recupera un role por su id
	 * @param id
	 * @return
	 */
	RoleEntity getById(Long id);
}
