package com.truongdx.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable {
	
	@Id
	@Column(name = "task_id", nullable=false)
	int id;
	
	@Column(name = "task_project_id")
	int projectid;
	
	@Column(name = "task_name")
	String name;
	
	@Column(name="task_createdate")
	String createdate;
	
	@Column(name = "task_user_create_id")
	int usercreateid;
	
	@Column(name = "task_description")
	String description;
	
	@Column(name ="task_result")
	String result;
	
	@Column(name = "task_request")
	String request;
	
	@Column(name = "task_status")
	int status;
	
	@Column(name = "task_process")
	int process;
	
	@Column(name = "task_enddate")
	String enddate;
	
	@Column(name = "task_note")
	String note;
	
	@Column(name = "task_isdelete")
	int isdelete;
	
	@Column(name = "task_deletedate")
	String deletedate;
	
	@Column(name = "task_user_delete_id")
	int deleteid;

	
	@ManyToOne
	@JoinColumn(name="project_id", nullable = false)
	Project project;
	
	@OneToMany(mappedBy = "task")
	Set<Comment> comments;
	
	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getUsercreateid() {
		return usercreateid;
	}

	public void setUsercreateid(int usercreateid) {
		this.usercreateid = usercreateid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	public int getDeleteid() {
		return deleteid;
	}

	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}

}
