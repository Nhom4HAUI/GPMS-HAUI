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
	@Column(name = "task_id", nullable = false)
	private int id;

	@Column(name = "task_name")
	private String name;

	@Column(name = "task_createdate")
	private String createdate;

	@Column(name = "task_user_create_id")
	private int usercreateid;

	@Column(name = "task_description")
	private String description;

	@Column(name = "task_result")
	private String result;

	@Column(name = "task_request")
	private String request;

	@Column(name = "task_status")
	private int status;

	@Column(name = "task_process")
	private int process;

	@Column(name = "task_enddate")
	private String enddate;

	@Column(name = "task_note")
	private String note;

	@Column(name = "task_isdelete")
	private int isdelete;

	@Column(name = "task_deletedate")
	private String deletedate;

	@Column(name = "task_user_delete_id")
	private int deleteid;

	@ManyToOne
	private GraduationProject graduationProject;

	@OneToMany(mappedBy = "task")
	private Set<Comment> comments;

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
