package com.truongdx.service;

import com.truongdx.domain.User;

import java.util.List;

public interface UserService {

	User findByUsername(String username);
	
	Iterable<User> findAll();

	List<User> seach(String q);
	
	User findOne(int id);
	
	List<User> findByFaculty(String faculty);

	void save(User user);

	void delete(int id);
}
