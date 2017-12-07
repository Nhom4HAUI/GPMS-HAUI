package com.truongdx.repository;

import com.truongdx.domain.RegistrationForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationFormRepository extends CrudRepository<RegistrationForm, Integer> {

    RegistrationForm findById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM Registration_Form r where r.team_id = ?1 and r.is_delte = ?2")
    RegistrationForm findByTeamIdAndDelete(int teamId, boolean delete);

    @Query(nativeQuery = true, value = "SELECT * FROM Registration_Form r where r.is_delte = b'0' AND r.project_id IN (SELECT id FROM Project WHERE lecture_id = ?1 AND status = 1)")
    List<RegistrationForm> getAllApproveProject(int id);
}
