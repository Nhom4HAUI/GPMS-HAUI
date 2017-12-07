package com.truongdx.service;


import com.truongdx.domain.Student;

public interface StudentService extends BaseService<Student>{

    Student findByUserId(int id);

    Student findById(int id);

}
