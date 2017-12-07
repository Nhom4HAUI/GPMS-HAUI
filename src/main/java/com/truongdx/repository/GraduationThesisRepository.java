package com.truongdx.repository;

import com.truongdx.domain.Graduationthesis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GraduationThesisRepository extends CrudRepository<Graduationthesis, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM graduationthesis g WHERE g.is_delte = b'0'")
    List<Graduationthesis> findAll();

    Graduationthesis findById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM graduationthesis g WHERE g.is_delte = b'0' AND g.lecture_id = ?1")
    List<Graduationthesis> getAllGPOfLecturer(int id);
}
