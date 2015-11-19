package com.restapp.service;

import java.util.List;

import com.restapp.exception.ContactsException;
import com.restapp.model.Contact;

public interface ContactService {
	
	public List<Contact> getAllContacts();
	
	public boolean addContact(Contact contact);
	
	public boolean deleteContact(Integer id);
	
	public Contact getContactById(Integer id) throws ContactsException;
	
	public boolean updateContact(Contact contact);
}
