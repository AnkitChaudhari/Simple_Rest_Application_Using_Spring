package com.restapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.restapp.common.ErrorCode;
import com.restapp.dao.ContactDao;
import com.restapp.entities.UserContact;
import com.restapp.exception.ContactsException;
import com.restapp.model.Contact;
import com.restapp.service.ContactService;

public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDaoImpl;

	public List<Contact> getAllContacts() throws ContactsException {
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

	public void addContact(Contact contact) throws ContactsException {

			UserContact userContact = new UserContact();
			String[] name = contact.getName().split(" ");
			userContact.setEmail(contact.getEmail());
			userContact.setFirstName(name[0]);
			userContact.setLastName(name[1]);
			userContact.setMobile(contact.getNumber());
			contactDaoImpl.addContact(userContact);
	}

	public void deleteContact(Integer id) throws ContactsException {
		contactDaoImpl.deleteContact(id);
	}

	@Override
	public Contact getContactById(Integer id) throws ContactsException {
		Contact contact = null;
		UserContact userContact = contactDaoImpl.getContactById(id);
		if (userContact == null) {
			throw new ContactsException(ErrorCode.CONTACT_NOT_FOUND);
		}
		contact = new Contact();
		contact.setId(userContact.getId());
		contact.setEmail(userContact.getEmail());
		contact.setName(userContact.getFirstName() + " "
				+ userContact.getLastName());
		contact.setNumber(userContact.getMobile());
		return contact;
	}

	@Override
	public void updateContact(Contact contact) throws ContactsException {
			UserContact userContact = new UserContact();
			userContact.setEmail(contact.getEmail());
			userContact.setId(contact.getId());
			userContact.setMobile(contact.getNumber());
			String[] name = contact.getName().split(" ");
			userContact.setFirstName(name[0]);
			userContact.setLastName(name[1]);
			contactDaoImpl.updateContact(userContact);
	}
}
