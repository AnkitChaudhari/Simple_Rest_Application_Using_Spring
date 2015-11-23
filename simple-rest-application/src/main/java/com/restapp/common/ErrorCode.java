package com.restapp.common;

public enum ErrorCode {
	
	CONTACT_NOT_SAVED("Contact cannot be added into Your Contactlist"),
	CONTACT_LIST_EMPTY("No contacts to display into the list"),
	CONTACT_NOT_FOUND("Contact Not Found"),
	CONTACT_NOT_DELETED("Contact cannot be deleted from your contactlist"),
	SERVICE_UNAVAILABLE("Service is temporary unavailable"),
	NAME_EMPTY("Name cannot be empty"),
	NAME_FORMAT("Please enter name in correct format.Use space(\" \") in name"),
	EMAIL_EMPTY("Email field cannot  be empty"),
	NUMBER_EMPTY("Number field cannot be empty"),
	ID_NOT_VALID("Contact Id is invalid"),
	CONTACT_NOT_SELECTED("Please select a contact to update");
	private String message;

	public String getMessage() {
		return message;
	}

	private ErrorCode(String message) {
		this.message = message;
	}
	
	

}
