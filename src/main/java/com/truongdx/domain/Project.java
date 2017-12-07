package com.truongdx.domain;

import javax.persistence.*;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int lectureId;
	private String addressApplicable;
	private String description;
	private String fieldOfApplication;
	private String name;
	private String requirement;

	/*
	* Nhóm đề tài
	* */
	private int groupProjectId;
	private String requirement_Basic;
	private String requirement_GP;
	private String contentProjectBasic;
	private String contentProject_GP;
	private String resuilt;
	private String summary;
	private int status;

	/*========================
	Hệ áp dụng của đề tài
	* Cao đẳng: 0
	* Đại học: 1
	* Cả 2: 2
	===========================*/
	private int type;

	@Column(name = "isDelte", nullable = true)
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public Project(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLectureId() {
		return lectureId;
	}

	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}

	public String getAddressApplicable() {
		return addressApplicable;
	}

	public void setAddressApplicable(String addressApplicable) {
		this.addressApplicable = addressApplicable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldOfApplication() {
		return fieldOfApplication;
	}

	public void setFieldOfApplication(String fieldOfApplication) {
		this.fieldOfApplication = fieldOfApplication;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    public int getGroupProjectId() {
        return groupProjectId;
    }

    public void setGroupProjectId(int groupProjectId) {
        this.groupProjectId = groupProjectId;
    }

    public String getRequirement_Basic() {
        return requirement_Basic;
    }

    public void setRequirement_Basic(String requirement_Basic) {
        this.requirement_Basic = requirement_Basic;
    }

    public String getRequirement_GP() {
        return requirement_GP;
    }

    public void setRequirement_GP(String requirement_GP) {
        this.requirement_GP = requirement_GP;
    }

    public String getContentProjectBasic() {
        return contentProjectBasic;
    }

    public void setContentProjectBasic(String contentProjectBasic) {
        this.contentProjectBasic = contentProjectBasic;
    }

    public String getContentProject_GP() {
        return contentProject_GP;
    }

    public void setContentProject_GP(String contentProject_GP) {
        this.contentProject_GP = contentProject_GP;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}