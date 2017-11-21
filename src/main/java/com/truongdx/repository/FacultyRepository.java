package com.truongdx.repository;

import com.truongdx.domain.Classes;
import com.truongdx.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
    public Faculty findByFacultyId(String facultyId);
}
