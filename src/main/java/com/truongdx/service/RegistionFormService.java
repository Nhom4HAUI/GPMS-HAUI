package com.truongdx.service;

import com.truongdx.domain.RegistrationForm;

import java.util.List;

public interface RegistionFormService extends BaseService<RegistrationForm> {
    RegistrationForm findById(int id);

    RegistrationForm findRegisttionFormApprove(int teamId, boolean isDelete);

    List<RegistrationForm> getAllApproveProject(int id);


}
