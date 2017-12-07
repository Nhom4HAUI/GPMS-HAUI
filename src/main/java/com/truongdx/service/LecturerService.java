package com.truongdx.service;

import com.truongdx.domain.Lecturer;
import com.truongdx.domain.Project;

import java.util.List;


public interface LecturerService {
    Iterable<Lecturer> findAll();

    Lecturer findById(int id);

    List<Lecturer> seach(String q);

    Lecturer findOne(int id);

    List<Lecturer> findByFaculty(String faculty);

    void save(Lecturer lecturer);

    List<Lecturer> getLectureByListProject(Iterable<Project> lsProject);

    void delete(int id);

    Lecturer findByUserId(int id);
}
