package com.truongdx.service;

import com.truongdx.domain.RegistrationForm;
import com.truongdx.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistionFormServiceImp implements RegistionFormService {

    @Autowired
    private RegistrationFormRepository registrationFormRepository;

    @Override
    public RegistrationForm findById(int id) {
        return registrationFormRepository.findById(id);
    }

    @Override
    public RegistrationForm findRegisttionFormApprove(int teamId, boolean isDelete) {
        return registrationFormRepository.findByTeamIdAndDelete(teamId,isDelete);
    }

    @Override
    public List<RegistrationForm> getAllApproveProject(int id) {
        return registrationFormRepository.getAllApproveProject(id);
    }

    @Override
    public Iterable<RegistrationForm> findAll() {
        return registrationFormRepository.findAll();
    }

    @Override
    public List<RegistrationForm> seach(String q) {
        return null;
    }

    @Override
    public RegistrationForm findOne(int id) {
        return null;
    }

    @Override
    public void save(RegistrationForm data) {
        registrationFormRepository.save(data);
    }

    @Override
    public void delete(int id) {
        registrationFormRepository.delete(id);
    }
}
