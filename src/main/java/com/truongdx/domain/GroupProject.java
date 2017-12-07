package com.truongdx.domain;


/*
* Nhóm đề tài
* */

import javax.persistence.*;

@Entity
@Table(name = "groupProject")
public class GroupProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int lecturerId;

    @Column(name = "isDelte", nullable = true)
    private Boolean delete;

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public GroupProject(){}

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
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
