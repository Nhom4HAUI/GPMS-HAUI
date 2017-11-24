package com.truongdx.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:32 PM
 */

@Entity
@Table(name = "sessionGP")
public class SessionGP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int duration;
	private int leaderId;
	private Date startDate;
	private int year;
	@Column(name = "isDelte", nullable = true)
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public SessionGP(){

	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}