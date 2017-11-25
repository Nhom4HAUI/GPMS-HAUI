package com.truongdx.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:32 PM
 */
@Entity
@Table(name = "student")
public class Student {
    private String access;
    private String address;
    private Date dob;
    private String email;
    private String firstName;
    private boolean gender;
    private String hktt;
    private int userId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastName;
    private String moble;
    private String nation;
    private String password;
    private String religion;

	private int classId;
	private String cv;
	private String description;
	private int teamId;
    private String username;
    @Column(name = "isDelte", nullable = true)
    private boolean delete;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getHktt() {
        return hktt;
    }

    public void setHktt(String hktt) {
        this.hktt = hktt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Student(){

	}

}