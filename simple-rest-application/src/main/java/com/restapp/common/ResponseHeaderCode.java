package com.restapp.common;

public enum ResponseHeaderCode {

	SUCCESS("0000"),
	FAILURE("0001"),
	WARNING("0002");
	
	private String code;

	private ResponseHeaderCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	
}
