package com.truongdx.service;

import com.truongdx.domain.Lecturer;
import com.truongdx.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    LecturerRepository lecturerRepository;

    @Override
    public Iterable<Lecturer> findAll() {
        return lecturerRepository.findAll();
    }

    @Override
    public List<Lecturer> seach(String q) {
        return null;
    }

    @Override
    public Lecturer findOne(int id) {
        return null;
    }

    @Override
    public List<Lecturer> findByFaculty(String faculty) {
        return null;
    }

    @Override
    public void save(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public void delete(int id) {
        lecturerRepository.delete(id);
    }
}
