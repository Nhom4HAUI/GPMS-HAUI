package com.truongdx.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Student> studentRoles;
    @ManyToMany(mappedBy = "roles")
    private Set<Lecturer> lectureRoles;
    @ManyToMany(mappedBy = "roles")
    private Set<Leader> leaderRoles;
/*    @ManyToMany(mappedBy = "roles")
    private Set<User> users;*/
@Column(name = "isDelte", nullable = true)
private boolean delete;

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public Set<Student> getStudentRoles() {
        return studentRoles;
    }

    public void setStudentRoles(Set<Student> studentRoles) {
        this.studentRoles = studentRoles;
    }

    public Set<Lecturer> getLectureRoles() {
        return lectureRoles;
    }

    public void setLectureRoles(Set<Lecturer> lectureRoles) {
        this.lectureRoles = lectureRoles;
    }

    public Set<Leader> getLeaderRoles() {
        return leaderRoles;
    }

    public void setLeaderRoles(Set<Leader> leaderRoles) {
        this.leaderRoles = leaderRoles;
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
