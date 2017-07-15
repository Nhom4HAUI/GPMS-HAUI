package com.truongdx.repository;

import org.springframework.data.repository.CrudRepository;

import com.truongdx.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
	
	
}
