package com.truongdx.elastic.model;

public class Text {
	String value,bold;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBold() {
		return bold;
	}

	public void setBold(String bold) {
		this.bold = bold;
	}

	public Text(String value, String bold) {
		super();
		this.value = value;
		this.bold = bold;
	}

	public Text() {
		super();
	}

	@Override
	public String toString() {
		return "Text [value=" + value + ", bold=" + bold + "]";
	}

	
}
