package com.truongdx.elastic.model;

import java.util.List;

public class SearchForm {
	private Query name,content;

	public Query getName() {
		return name;
	}

	public void setName(Query name) {
		this.name = name;
	}

	public Query getContent() {
		return content;
	}

	public void setContent(Query content) {
		this.content = content;
	}

	public SearchForm(Query name, Query content) {
		super();
		this.name = name;
		this.content = content;
	}
	public SearchForm(){
		name = new Query(Project.PROJECT_NAME,"");
		content = new Query(Project.PROJECT_CONTENT,"");
	}


}
