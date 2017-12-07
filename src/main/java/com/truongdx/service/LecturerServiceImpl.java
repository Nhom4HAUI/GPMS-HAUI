package com.truongdx.service;

import com.truongdx.domain.Lecturer;
import com.truongdx.domain.Project;
import com.truongdx.repository.FacultyRepository;
import com.truongdx.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    LecturerRepository lecturerRepository;

    @Override
    public Iterable<Lecturer> findAll() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer findById(int id) {
        return lecturerRepository.findById(id);
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
        return lecturerRepository.findByFacultyId(facultyRepository.findByFacultyId(faculty).getId());
    }

    @Override
    public void save(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public List<Lecturer> getLectureByListProject(Iterable<Project> lsProject) {
        List<Lecturer> lsLecturer = new ArrayList<>();
        if (lsProject != null)
            for (Project project :
                    lsProject) {
                lsLecturer.add(lecturerRepository.findById(project.getLectureId()));
            }

        return lsLecturer;
    }

    @Override
    public void delete(int id) {
        lecturerRepository.delete(id);
    }

    @Override
    public Lecturer findByUserId(int id) {
        return lecturerRepository.findByUserId(id);
    }
}
