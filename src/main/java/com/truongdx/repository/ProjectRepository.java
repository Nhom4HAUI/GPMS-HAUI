package com.truongdx.repository;

import com.truongdx.domain.Project;
import com.truongdx.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project findById(int id);

    @Query(value = "SELECT * FROM Project p where p.id not in (SELECT g.project_id FROM Graduationthesis g)", nativeQuery = true)
    List<Project> getAllProjectNotLeading();

    String test = "SELECT * FROM Project p where p.status =1 AND p.is_delte = b'0' AND p.lecture_id IN (SELECT id FROM LECTURE l WHERE l.faculty_id IN (SELECT id FROM Faculty f WHERE f.faculty_id = ?1))";
    @Query(nativeQuery = true, value = test)
    Iterable<Project> getAllProjectByFacyltyId(String facultyId);

    @Query(nativeQuery = true, value = "SELECT * FROM Project p where p.status >0")
    List<Project> getAllProjectLeading();

    List<Project> findByLectureId(int id);
}
