package com.truongdx.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "class")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String classId;
	private int facultyId;
	private String facultyName;
	private String name;

    public Classes(){	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
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