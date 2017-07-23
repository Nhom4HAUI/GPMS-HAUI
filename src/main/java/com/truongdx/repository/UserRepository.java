package com.truongdx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.truongdx.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);

	List<User> findByUsernameContaining(String q);

	@Query("select distinct u.faculty from User u")
	List<String> getAllFaculty();

	List<User> findByFaculty(String faculty);

}
