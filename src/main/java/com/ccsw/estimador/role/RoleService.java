package com.ccsw.estimador.role;

import com.ccsw.estimador.role.model.RoleEntity;

/**
 * @author iciudade
 *
 */
public interface RoleService {

	/**
	 * Recupera rol con su name
	 * @param name
	 * @return
	 */
	RoleEntity getByName(String name);

	/**
	 * Recupera el rol con su id
	 * @param id
	 * @return
	 */
	RoleEntity getById(Long id);
}
