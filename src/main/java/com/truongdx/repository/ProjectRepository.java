package com.truongdx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.truongdx.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	
	List<Project> findByInstructorId(Integer id);
	
	
}
