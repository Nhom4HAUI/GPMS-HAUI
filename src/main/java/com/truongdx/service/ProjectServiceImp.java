package com.truongdx.service;

import com.truongdx.domain.Project;
import com.truongdx.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> seach(String q) {
        return null;
    }

    @Override
    public Project findOne(int id) {
        return null;
    }

    @Override
    public void save(Project data) {
        projectRepository.save(data);
    }

    @Override
    public void delete(int id) {
        Project project = projectRepository.findById(id);
        project.setDelete(true);
        this.save(project);
    }

    @Override
    public Project findById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> getAllProjectNotLeading() {
        return projectRepository.getAllProjectNotLeading();
    }

    @Override
    public Iterable<Project> getAllProjectNotLeadingByFacultyId(String facultyid) {
        return projectRepository.getAllProjectByFacyltyId(facultyid);
    }

    @Override
    public List<Project> findByLectureId(int id) {
        return projectRepository.findByLectureId(id);
    }

    @Override
    public List<Project> getAllProjectLeading() {
        return projectRepository.getAllProjectLeading();
    }
}
