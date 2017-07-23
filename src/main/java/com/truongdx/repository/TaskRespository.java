package com.truongdx.repository;

import org.springframework.data.repository.CrudRepository;

import com.truongdx.domain.Task;

public interface TaskRespository extends CrudRepository<Task, Integer> {
	
	
	
}
