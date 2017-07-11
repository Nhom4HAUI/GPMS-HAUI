package com.truongdx.repository;

import org.springframework.data.repository.CrudRepository;

import com.truongdx.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
	
}
