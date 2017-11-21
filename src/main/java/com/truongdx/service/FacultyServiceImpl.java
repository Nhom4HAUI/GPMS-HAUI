package com.truongdx.service;

import com.truongdx.domain.Faculty;
import com.truongdx.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Iterable<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(String facultyId) {
        return facultyRepository.findByFacultyId(facultyId);
    }

}
