package com.restapp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restapp.common.ResponseHeaderCode;
import com.restapp.common.ResponseHeaderMessage;
import com.restapp.exception.ContactsException;
import com.restapp.model.ContactResponse;
import com.restapp.util.ResponseGenerator;

@ControllerAdvice
public class ContactExceptionHandler {

	@ResponseBody 
	@ExceptionHandler(ContactsException.class)
	public ContactResponse handleContactsException(ContactsException exception)
	{
		ContactResponse response=ResponseGenerator.generateResponse(ResponseHeaderCode.FAILURE, ResponseHeaderMessage.FAILURE, exception.getErrorCode().getMessage());
		
		return response;
	}
}
