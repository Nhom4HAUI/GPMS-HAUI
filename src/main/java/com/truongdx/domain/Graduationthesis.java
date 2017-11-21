package com.truongdx.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Graduationthesis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    private Date endDate;
    private int examinationCounciId;
    private int teamId;
    private int scoreId;
    private int lectureId;
    private String linkProject;
    private int projectId;
    private int registrationFormId;
    private int sessionGPId;
    private Date startDate;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getExaminationCounciId() {
        return examinationCounciId;
    }

    public void setExaminationCounciId(int examinationCounciId) {
        this.examinationCounciId = examinationCounciId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLinkProject() {
        return linkProject;
    }

    public void setLinkProject(String linkProject) {
        this.linkProject = linkProject;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getRegistrationFormId() {
        return registrationFormId;
    }

    public void setRegistrationFormId(int registrationFormId) {
        this.registrationFormId = registrationFormId;
    }

    public int getSessionGPId() {
        return sessionGPId;
    }

    public void setSessionGPId(int sessionGPId) {
        this.sessionGPId = sessionGPId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
