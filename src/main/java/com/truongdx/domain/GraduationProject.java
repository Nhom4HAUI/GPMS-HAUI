package com.truongdx.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "graduation_project")
public class GraduationProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "graduation_project_approvalStatus")
	private int approvalStatus;

	@Column(name = "graduation_project_startDate")
	private Date startDate;

	@Column(name = "graduation_project_endDate")
	private Date endDate;

	@Column(name = "graduation_project_implementTime")
	private int implementTime;

	@OneToMany(mappedBy = "graduationProjects", fetch = FetchType.LAZY)
	private Set<User> users;

	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;
	
	@OneToOne(mappedBy = "graduationProject")
	private Document document;

	@OneToMany(mappedBy = "graduationProject")
	private Set<Task> tasks;

	@Column(name = "graduation_project_isActive")
	private boolean active;

	@Column(name = "graduation_project_isDelete")
	private boolean delete;

	@Column(name = "graduation_project_deleteId")
	private int deleteId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getImplementTime() {
		return implementTime;
	}

	public void setImplementTime(int implementTime) {
		this.implementTime = implementTime;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public int getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
	}

	
}
