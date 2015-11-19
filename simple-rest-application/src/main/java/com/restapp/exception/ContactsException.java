package com.restapp.exception;

import com.restapp.common.ErrorCode;

public class ContactsException extends Exception{
	private ErrorCode errorCode;

	public ContactsException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	

}
