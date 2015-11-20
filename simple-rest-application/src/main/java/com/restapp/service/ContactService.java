package com.restapp.service;

import java.util.List;

import com.restapp.exception.ContactsException;
import com.restapp.model.Contact;

public interface ContactService {
	
	public List<Contact> getAllContacts() throws ContactsException;
	
	public void addContact(Contact contact) throws ContactsException;
	
	public void deleteContact(Integer id) throws ContactsException;
	
	public Contact getContactById(Integer id) throws ContactsException;
	
	public void updateContact(Contact contact) throws ContactsException;
}
