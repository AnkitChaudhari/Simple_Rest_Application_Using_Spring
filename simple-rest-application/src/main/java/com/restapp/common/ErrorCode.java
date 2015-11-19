package com.restapp.common;

public enum ErrorCode {
	
	CONTACT_NOT_SAVED("Contact cannot be added into Your Contactlist"),
	CONTACT_LIST_EMPTY("No contacts to display into the list"),
	CONTACT_NOT_FOUND("No contact found"),
	CONTACT_NOT_DELETED("Contact cannot be deleted from your contactlist"),
	SERVICE_UNAVAILABLE("Service is temporary unavailable");
	
	private String message;

	public String getMessage() {
		return message;
	}

	private ErrorCode(String message) {
		this.message = message;
	}
	
	

}
