package com.truongdx.repository;

import com.truongdx.domain.Classes;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Classes, Integer> {
    public Classes findByClassId(String classId);
}
