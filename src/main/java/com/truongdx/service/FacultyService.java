package com.truongdx.service;

import com.truongdx.domain.Faculty;
import org.springframework.stereotype.Service;


public interface FacultyService {
    public Iterable<Faculty> findAll();

    public Faculty findById(String facultyId);
}
