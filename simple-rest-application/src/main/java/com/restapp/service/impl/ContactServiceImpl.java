package com.restapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.restapp.dao.ContactDao;
import com.restapp.entities.UserContact;
import com.restapp.exception.ContactsException;
import com.restapp.model.Contact;
import com.restapp.service.ContactService;

public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDaoImpl;

	public List<Contact> getAllContacts() {
		List<UserContact> contacts = contactDaoImpl.getAllContacts();
		List<Contact> contactList = new ArrayList<Contact>();
		for (UserContact contact : contacts) {
			Contact con = new Contact();
			con.setId(contact.getId());
			con.setName(contact.getFirstName() + " " + contact.getLastName());
			con.setEmail(contact.getEmail());
			con.setNumber(contact.getMobile());
			contactList.add(con);
		}
		return contactList;
	}

	public boolean addContact(Contact contact) {

		boolean status = false;
		try {
			UserContact userContact = new UserContact();
			String[] name = contact.getName().split(" ");
			userContact.setEmail(contact.getEmail());
			userContact.setFirstName(name[0]);
			userContact.setLastName(name[1]);
			userContact.setMobile(contact.getNumber());
			status = contactDaoImpl.addContact(userContact);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return status;
	}

	public boolean deleteContact(Integer id) {
		boolean status = false;
		try {
			status = contactDaoImpl.deleteContact(id);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public Contact getContactById(Integer id) throws ContactsException{
		Contact contact = null;
		try {
			UserContact userContact = contactDaoImpl.getContactById(id);
			contact = new Contact();
			contact.setId(userContact.getId());
			contact.setEmail(userContact.getEmail());
			contact.setName(userContact.getFirstName() + " "
					+ userContact.getLastName());
			contact.setNumber(userContact.getMobile());
		} catch (Exception exception) {
			exception.printStackTrace();
			if(exception instanceof ContactsException)
				throw exception;
		}
		return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		try {
			UserContact userContact = new UserContact();
			userContact.setEmail(contact.getEmail());
			userContact.setId(contact.getId());
			userContact.setMobile(contact.getNumber());
			String[] name = contact.getName().split(" ");
			userContact.setFirstName(name[0]);
			userContact.setLastName(name[1]);
			return contactDaoImpl.updateContact(userContact);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
}
