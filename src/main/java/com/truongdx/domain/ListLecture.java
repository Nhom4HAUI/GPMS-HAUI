package com.truongdx.domain;

import javax.persistence.*;

@Entity
@Table(name = "listLecture")
public class ListLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int lectureId;
    private int examinationCouncilId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getExaminationCouncilId() {
        return examinationCouncilId;
    }

    public void setExaminationCouncilId(int examinationCouncilId) {
        this.examinationCouncilId = examinationCouncilId;
    }
}
