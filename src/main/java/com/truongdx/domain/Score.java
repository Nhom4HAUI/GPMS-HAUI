package com.truongdx.domain;

import javax.persistence.*;

/**
 * @author truon
 * @version 1.0
 * @created 05-Nov-2017 4:08:31 PM
 */
public class Score {

	private int examinationCouncilId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int lecturerId;
	private int score;

	@OneToOne(mappedBy = "score")
	private Graduationthesis graduationthesis;

	@ManyToOne
	private ExaminationCouncil examinationCouncil;



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

	public Graduationthesis getGraduationthesis() {
		return graduationthesis;
	}

	public void setGraduationthesis(Graduationthesis graduationthesis) {
		this.graduationthesis = graduationthesis;
	}

	public ExaminationCouncil getExaminationCouncil() {
		return examinationCouncil;
	}

	public void setExaminationCouncil(ExaminationCouncil examinationCouncil) {
		this.examinationCouncil = examinationCouncil;
	}
}