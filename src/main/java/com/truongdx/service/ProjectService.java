package com.truongdx.service;

import com.truongdx.domain.Project;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectService extends BaseService<Project> {

    Project findById(int id);

    List<Project> getAllProjectNotLeading();

    Iterable<Project> getAllProjectNotLeadingByFacultyId(String faculty);

    List<Project> findByLectureId(int id);

    List<Project> getAllProjectLeading();
}
