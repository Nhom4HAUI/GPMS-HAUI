package com.truongdx.domain;

import javax.persistence.*;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int lectureId;
	private int addressApplicable;
	private String description;
	private String fieldOfApplication;
	private String name;
	private String requirement;
	private String resuilt;
	private String summary;
	@Column(name = "isDelte", nullable = true)
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public Project(){

	}

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

	public int getAddressApplicable() {
		return addressApplicable;
	}

	public void setAddressApplicable(int addressApplicable) {
		this.addressApplicable = addressApplicable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldOfApplication() {
		return fieldOfApplication;
	}

	public void setFieldOfApplication(String fieldOfApplication) {
		this.fieldOfApplication = fieldOfApplication;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getResuilt() {
		return resuilt;
	}

	public void setResuilt(String resuilt) {
		this.resuilt = resuilt;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}