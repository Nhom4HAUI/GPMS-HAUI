package com.truongdx.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	@Id
	@Column(name = "project_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "project_name", nullable = false)
	private String name;

	@Column(name = "project_request")
	private String request;

	@Column(name = "project_result")
	private String result;

	@Column(name = "project_description")
	private String description;

	@Column(name = "project_placeOfDeployment")
	private String placeOfDeployment;

	@Column(name = "project_status")
	private int status;

	@Column(name = "project_contentlink")
	private String contentlink;

	@Column(name = "project_viewcount")
	private int viewcount;

	@Column(name = "project_isdelete")
	private int delete;

	@Column(name = "project_deletedate")
	private String deletedate;

	@Column(name = "project_deleteid")
	private int deleteId;

	@Column(name = "project_specialized")
	private String specialized;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User instructor;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<GraduationProject> graduationProjects;

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

	public String getContentlink() {
		return contentlink;
	}

	public void setContentlink(String contentlink) {
		this.contentlink = contentlink;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	public int getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}

}
