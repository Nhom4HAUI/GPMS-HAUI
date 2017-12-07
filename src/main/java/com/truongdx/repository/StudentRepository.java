package com.truongdx.repository;

import com.truongdx.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByUsername(String username);

    List<Student> findByUsernameContaining(String q);

    Student findByUserId(int id);

    Student findById(int id);
}
