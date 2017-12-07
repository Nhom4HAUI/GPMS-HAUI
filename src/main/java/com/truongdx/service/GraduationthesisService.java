package com.truongdx.service;

import com.truongdx.domain.Graduationthesis;
import com.truongdx.service.BaseService;

import java.util.List;

public interface GraduationthesisService extends BaseService<Graduationthesis> {

    Graduationthesis findById(int id);

    List<Graduationthesis> getAllGPOfLecturer(int id);

}
