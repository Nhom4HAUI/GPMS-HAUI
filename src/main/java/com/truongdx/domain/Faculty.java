package com.truongdx.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String facultyId;
	private String name;
    private int leaderId;
	@Column(name = "isDelte", nullable = true)
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public Faculty(String facultyId, String name, int leaderId) {
		this.facultyId = facultyId;
		this.name = name;
		this.leaderId = leaderId;
	}

	public Faculty(){

	}

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
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

}