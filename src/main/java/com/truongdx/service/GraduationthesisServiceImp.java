package com.truongdx.service;

import com.truongdx.domain.Graduationthesis;
import com.truongdx.repository.GraduationThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GraduationthesisServiceImp implements  GraduationthesisService{

    @Autowired
    GraduationThesisRepository graduationThesisRepository;

    @Override
    public Iterable<Graduationthesis> findAll() {
        return graduationThesisRepository.findAll();
    }

    @Override
    public List<Graduationthesis> seach(String q) {
        return null;
    }

    @Override
    public Graduationthesis findOne(int id) {
        return null;
    }

    @Override
    public void save(Graduationthesis data) {
        graduationThesisRepository.save(data);
    }

    @Override
    public void delete(int id) {
        Graduationthesis graduationthesis = graduationThesisRepository.findById(id);
        graduationthesis.setDelete(true);
        this.save(graduationthesis);
    }

    @Override
    public Graduationthesis findById(int id) {
        return graduationThesisRepository.findById(id);
    }

    @Override
    public List<Graduationthesis> getAllGPOfLecturer(int id) {
        return graduationThesisRepository.getAllGPOfLecturer(id);
    }
}
