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

    private int graduationThesisId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @OneToMany(mappedBy = "examinationCouncil")
    private Set<Leader> leaders;

    private int listLectureID;
    private String name;

    @OneToMany(mappedBy = "examinationCouncil")
    private Set<Score> score;

    public ExaminationCouncil() {

    }

    public int getGraduationThesisId() {
        return graduationThesisId;
    }

    public void setGraduationThesisId(int graduationThesisId) {
        this.graduationThesisId = graduationThesisId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Leader> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<Leader> leaders) {
        this.leaders = leaders;
    }

    public int getListLectureID() {
        return listLectureID;
    }

    public void setListLectureID(int listLectureID) {
        this.listLectureID = listLectureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Score> getScore() {
        return score;
    }

    public void setScore(Set<Score> score) {
        this.score = score;
    }
}