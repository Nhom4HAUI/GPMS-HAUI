package com.truongdx.domain;

import javax.persistence.*;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:32 PM
 */

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int registrationFormId;
	private String name;
	@Column(name = "isDelte", nullable = true)
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public Team(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegistrationFormId() {
		return registrationFormId;
	}

	public void setRegistrationFormId(int registrationFormId) {
		this.registrationFormId = registrationFormId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}