package com.truongdx.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:32 PM
 */

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String comment;
	private int duration;
	private int graduationThesisId;
	private String linkTask;
	private String name;
	private int percentCompletion = 0;
	private int proposerId;
	private String requirement;
	private String resuilt;
	private Date startDate;
	private int status;
	private int typeTask;

	public Task(){

	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getGraduationThesisId() {
		return graduationThesisId;
	}

	public void setGraduationThesisId(int graduationThesisId) {
		this.graduationThesisId = graduationThesisId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinkTask() {
		return linkTask;
	}

	public void setLinkTask(String linkTask) {
		this.linkTask = linkTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentCompletion() {
		return percentCompletion;
	}

	public void setPercentCompletion(int percentCompletion) {
		this.percentCompletion = percentCompletion;
	}

	public int getProposerId() {
		return proposerId;
	}

	public void setProposerId(int proposerId) {
		this.proposerId = proposerId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTypeTask() {
		return typeTask;
	}

	public void setTypeTask(int typeTask) {
		this.typeTask = typeTask;
	}
}