package com.restapp.common;

public enum ResponseHeaderMessage {

	SUCCESS("SUCCESS"), FAILURE("FAILED"), WARNING("WARNING");

	private String message;

	public String getMessage() {
		return message;
	}

	private ResponseHeaderMessage(String message) {
		this.message = message;
	}

}
