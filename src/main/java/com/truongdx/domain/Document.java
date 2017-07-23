package com.truongdx.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document implements Serializable{
	@Id
	@Column(name = "document_id", nullable = false)
	int id;
	
	@Column(name = "document_status")
	int status;
	
	@Column(name = "document_note")
	String note;
	
	@Column(name = "document_isdelete")
	int delete;
	
	@Column(name = "document_delete_userid")
	int deleteid;
	
	@Column(name = "document_delete_date")
	String deletedate;
	
	
	@OneToOne
	Project project;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public int getDeleteid() {
		return deleteid;
	}

	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	
	
}
