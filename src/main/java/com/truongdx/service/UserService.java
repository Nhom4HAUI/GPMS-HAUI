package com.truongdx.service;

import java.util.List;

import com.truongdx.domain.User;

public interface UserService {
	
	Iterable<User> findAll();

	List<User> seach(String q);
	
	User findOne(int id);
	
	List<User> findByFaculty(String faculty);

	void save(User user);

	void delete(int id);
}
