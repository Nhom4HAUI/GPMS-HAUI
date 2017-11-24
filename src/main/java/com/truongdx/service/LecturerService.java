package com.truongdx.service;

import com.truongdx.domain.Lecturer;

import java.util.List;


public interface LecturerService {
    Iterable<Lecturer> findAll();

    List<Lecturer> seach(String q);

    Lecturer findOne(int id);

    List<Lecturer> findByFaculty(String faculty);

    void save(Lecturer lecturer);

    void delete(int id);
}
