package com.truongdx.repository;



import org.springframework.data.repository.CrudRepository;

import com.truongdx.domain.Document;

public interface DocumentRepository extends CrudRepository<Document, Integer>{
	
}
