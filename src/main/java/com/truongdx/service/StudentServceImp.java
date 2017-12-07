package com.truongdx.service;

import com.truongdx.domain.Student;
import com.truongdx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> seach(String q) {
        return null;
    }

    @Override
    public Student findOne(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void save(Student data) {
        studentRepository.save(data);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);

    }

    @Override
    public Student findByUserId(int id) {
        return studentRepository.findByUserId(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
