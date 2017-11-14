package com.truongdx.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */

@Entity
@Table(name = "leader")
public class Leader extends User {

	private String job;

	@ManyToOne
	public ExaminationCouncil examinationCouncil;


	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public ExaminationCouncil getExaminationCouncil() {
		return examinationCouncil;
	}

	public void setExaminationCouncil(ExaminationCouncil examinationCouncil) {
		this.examinationCouncil = examinationCouncil;
	}

	public Leader(){

	}

}