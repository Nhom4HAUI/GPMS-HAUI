package com.truongdx.domain;

import javax.persistence.OneToOne;
import java.util.Date;

public class RegistrationForm {
    private int id;
    private String description;
    private int projectId;
    private String reason;
    private Date registrationDate;
    private int status;

    @OneToOne(mappedBy = "registrationForm")
    private Team team;
}
