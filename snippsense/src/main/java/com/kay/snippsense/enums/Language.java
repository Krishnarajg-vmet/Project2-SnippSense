package com.kay.snippsense.enums;

public enum Language {
	
	JAVA("JAVA"),
	PYTHON("Python"),
	HTML("HTML"),
	CSS("CSS"),
	JS("JavaScript"),
	OTHERS("Others");
	
	private final String displayName;

	Language(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
