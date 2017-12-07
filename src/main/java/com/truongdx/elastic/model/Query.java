package com.truongdx.elastic.model;

public class Query {
	String field,value;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Query(String field, String value) {
		super();
		this.field = field;
		this.value = value;
	}
	public Query() {}
}
