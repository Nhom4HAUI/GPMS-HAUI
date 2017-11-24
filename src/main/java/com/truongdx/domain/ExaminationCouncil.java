package com.truongdx.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */

@Entity
@Table(name = "examinationCouncil")
public class ExaminationCouncil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int listLectureId;
    private String name;
    private int lectureId;
    @Column(name = "isDelte", nullable = true)
    private boolean delete;

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
    public ExaminationCouncil() {

    }

    public int getListLectureId() {
        return listLectureId;
    }

    public void setListLectureId(int listLectureId) {
        this.listLectureId = listLectureId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}