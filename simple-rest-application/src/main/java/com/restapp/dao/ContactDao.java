package com.restapp.dao;

import java.util.List;

import com.restapp.entities.UserContact;
import com.restapp.exception.ContactsException;

public interface ContactDao {
	
	public List<UserContact> getAllContacts();
	
	public boolean addContact(UserContact contact);
	
	public boolean deleteContact(Integer id);
	
	public UserContact getContactById(Integer id) throws ContactsException;
	
	public boolean updateContact(UserContact contact);
}
