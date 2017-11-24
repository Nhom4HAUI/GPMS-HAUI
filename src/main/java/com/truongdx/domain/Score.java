package com.truongdx.domain;

import javax.persistence.*;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */

@Entity
@Table(name = "score")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int lecturerId;
	private int score;
	private int examinationCouncilId;
	private int graduationThesisId;
	@Column(name = "isDelte", nullable = true)
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}


	public Score(){

	}

	public int getExaminationCouncilId() {
		return examinationCouncilId;
	}

	public void setExaminationCouncilId(int examinationCouncilId) {
		this.examinationCouncilId = examinationCouncilId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGraduationThesisId() {
		return graduationThesisId;
	}

	public void setGraduationThesisId(int graduationThesisId) {
		this.graduationThesisId = graduationThesisId;
	}
}