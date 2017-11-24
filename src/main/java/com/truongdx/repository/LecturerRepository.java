package com.truongdx.repository;

import com.truongdx.domain.Lecturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
    Lecturer findByUsername(String username);

    List<Lecturer> findByUsernameContaining(String q);

    List<Lecturer> findByFacultyId(int facultyId);
}
