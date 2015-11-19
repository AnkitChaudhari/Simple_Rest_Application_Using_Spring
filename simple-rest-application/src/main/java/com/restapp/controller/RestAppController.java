package com.restapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.restapp.common.ResponseHeaderCode;
import com.restapp.common.ResponseHeaderMessage;
import com.restapp.exception.ContactsException;
import com.restapp.model.Contact;
import com.restapp.model.ContactResponse;
import com.restapp.service.impl.ContactServiceImpl;
import com.restapp.util.ResponseGenerator;

@RestController
public class RestAppController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	@RequestMapping("/home")
	public ModelAndView showHomePage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/getContacts", method = RequestMethod.GET)
	public ContactResponse getAllContacts() {
		List<Contact> contacts = contactServiceImpl.getAllContacts();
		return ResponseGenerator.generateResponse(ResponseHeaderCode.SUCCESS, ResponseHeaderMessage.SUCCESS, contacts);
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ContactResponse addContact(@RequestBody Contact contact) {
		if(contactServiceImpl.addContact(contact))
			return ResponseGenerator.generateResponse(ResponseHeaderCode.SUCCESS, ResponseHeaderMessage.SUCCESS, null);
		else
			return ResponseGenerator.generateResponse(ResponseHeaderCode.FAILURE, ResponseHeaderMessage.FAILURE, null);
	}

	@RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
	public ContactResponse deleteContact(@PathVariable Integer id) {
		if(contactServiceImpl.deleteContact(id))
			return ResponseGenerator.generateResponse(ResponseHeaderCode.SUCCESS, ResponseHeaderMessage.SUCCESS, null);
		else
			return ResponseGenerator.generateResponse(ResponseHeaderCode.FAILURE, ResponseHeaderMessage.FAILURE, null);
	}

	@RequestMapping(value = "/editContact/{id}", method = RequestMethod.PUT)
	public ContactResponse editContact(@PathVariable Integer id) {
		ContactResponse response=null;
		try {
			Contact contact= contactServiceImpl.getContactById(id);
			response=ResponseGenerator.generateResponse(ResponseHeaderCode.SUCCESS, ResponseHeaderMessage.SUCCESS, contact);
		} catch (ContactsException e) {
			e.printStackTrace();
			response=ResponseGenerator.generateResponse(ResponseHeaderCode.FAILURE, ResponseHeaderMessage.FAILURE, e.getErrorCode().getMessage());
		}
		finally{
			return response;	
		}
		
		
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.POST)
	public ContactResponse updateContact(@RequestBody Contact contact) {
		if(contactServiceImpl.updateContact(contact))
			return ResponseGenerator.generateResponse(ResponseHeaderCode.SUCCESS, ResponseHeaderMessage.SUCCESS, null);
		else
			return ResponseGenerator.generateResponse(ResponseHeaderCode.FAILURE, ResponseHeaderMessage.FAILURE, null);
	}
}
