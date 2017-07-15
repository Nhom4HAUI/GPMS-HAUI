package com.truongdx.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	int id;
	
	@Column(name = "project_name", nullable=false)
	String name;
	
	@Column(name = "project_contentlink")
	String contentlink;
	
	@Column(name = "project_studentid")
	int studentId;
	
	@Column(name = "project_instructorid")
	int instructorId;
	
	@Column(name = "project_progree")
	int progree;
	
	@Column(name = "project_startdate")
	String startdate;
	
	@Column(name = "project_status")
	int status;
	
	@Column(name = "project_description")
	String description;
	
	@Column(name = "project_score")
	int score;
	
	@Column(name = "project_viewcount")
	int viewcount;
	
	@Column(name = "project_cancel")
	int cancel;
	
	@Column(name = "project_isdelete")
	int delete;
	
	@Column(name = "project_deletedate")
	String deletedate;
	
	@Column(name = "project_deleteid")
	int deleteId;
	
	@Column(name ="project_result")
	String result;
	
	@Column(name = "project_request")
	String request;
	
	@Column(name = "project_specialized")
	String specialized;

	@ManyToOne
	@JoinColumn(name="user_id", nullable = true)
	User users;
	
	
	@OneToMany(mappedBy="project")
	Set<Task> tasks;
		
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
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

	public String getContentlink() {
		return contentlink;
	}

	public void setContentlink(String contentlink) {
		this.contentlink = contentlink;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public int getProgree() {
		return progree;
	}

	public void setProgree(int progree) {
		this.progree = progree;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
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
