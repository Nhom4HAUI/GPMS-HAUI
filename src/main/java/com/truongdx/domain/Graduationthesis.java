package com.truongdx.domain;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;

public class Graduationthesis {
    private int id;
    private String comment;
    private Date endDate;
    private int examinationCounciId;
    private int lectureId;
    private String linkProject;
    private int projectId;
    private int registrationFormId;
    private int sessionGPId;
    private Date startDate;
    private int status;

    @OneToOne(fetch = FetchType.EAGER)
    private Score score;
}
