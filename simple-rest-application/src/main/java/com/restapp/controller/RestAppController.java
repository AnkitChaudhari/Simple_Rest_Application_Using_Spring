package com.restapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.restapp.model.Contact;

@RestController
public class RestAppController {
	
	@RequestMapping("/home")
	public ModelAndView showHomePage()
	{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/getContacts",method=RequestMethod.GET)
	public List<Contact> getAllContacts()
	{
		List<Contact> contacts=new ArrayList<Contact>();
		Contact contact=new Contact();
		contact.setName("Ankit Chaudhari");
		contact.setEmail("chaudhari.ankit61@gmail.com");
		contact.setNumber("8806524861");
		contacts.add(contact);
		return contacts;
	}
}
