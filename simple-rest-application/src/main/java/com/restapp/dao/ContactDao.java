package com.restapp.dao;

import java.util.List;

import com.restapp.entities.UserContact;
import com.restapp.exception.ContactsException;

public interface ContactDao {
	
	public List<UserContact> getAllContacts() throws ContactsException;
	
	public void addContact(UserContact contact) throws ContactsException;
	
	public void deleteContact(Integer id) throws ContactsException;
	
	public UserContact getContactById(Integer id) throws ContactsException;
	
	public void updateContact(UserContact contact) throws ContactsException;
}
