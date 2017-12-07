package com.truongdx.elastic.model;

public class Project {
	private String id,name,content;
	private float score;

	public static String PROJECT_INDEX = "project";
	public static String PROJECT_TYPE = "document";
	public static String PROJECT_ID = "id";
	public static String PROJECT_NAME = "name";
	public static String PROJECT_CONTENT = "content";
	public static String PROJECT_HIT_SCORE = "score";
	
	public Project() {}
	public Project(String id, String name, String content) {
		this.id = id;
		this.name = name;
		this.content = content;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
