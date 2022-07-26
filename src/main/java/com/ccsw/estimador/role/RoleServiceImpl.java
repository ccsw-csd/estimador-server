package com.ccsw.estimador.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.estimador.role.model.RoleEntity;

/**
 * @author iciudade
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RoleEntity getByName(String name) {
		
		return this.roleRepository.getByName(name);
	}

	@Override
	public RoleEntity getById(Long id) {
		
		return this.roleRepository.getById(id);
	}

}
