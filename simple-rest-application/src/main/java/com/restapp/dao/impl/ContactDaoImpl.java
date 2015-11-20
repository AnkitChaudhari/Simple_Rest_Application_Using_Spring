package com.restapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.restapp.common.ErrorCode;
import com.restapp.dao.ContactDao;
import com.restapp.entities.UserContact;
import com.restapp.exception.ContactsException;

public class ContactDaoImpl extends EntityManagerFactory implements ContactDao {

	@Override
	public List<UserContact> getAllContacts() throws ContactsException {
		try
		{
			Query query = getEntityManager().createQuery("FROM UserContact");
			return query.list();	
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw new ContactsException(ErrorCode.SERVICE_UNAVAILABLE);
		}
		
	}

	@Override
	public void addContact(UserContact contact) throws ContactsException {
		try {
			Session session = getEntityManager();
			session.getTransaction().begin();
			session.persist(contact);
			session.getTransaction().commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ContactsException(ErrorCode.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	public void deleteContact(Integer id) throws ContactsException {
		try {
			Session session = getEntityManager();
			UserContact contact = (UserContact) session.get(UserContact.class,
					id);
			if(contact==null)
				throw new ContactsException(ErrorCode.CONTACT_NOT_FOUND);
			session.getTransaction().begin();
			session.delete(contact);
			session.getTransaction().commit();
		}catch(ContactsException exception)
		{
			exception.printStackTrace();
			throw exception;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw new ContactsException(ErrorCode.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	public UserContact getContactById(Integer id) throws ContactsException {
		UserContact contact = null;
		try {
			contact = (UserContact) getEntityManager().get(UserContact.class, id);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ContactsException(ErrorCode.SERVICE_UNAVAILABLE);
		}
		return contact;
	}

	@Override
	public void updateContact(UserContact contact) throws ContactsException {
		try {
			Session session = getEntityManager();
			if(session.get(UserContact.class, contact.getId())==null)
				throw new ContactsException(ErrorCode.CONTACT_NOT_FOUND);
			session.getTransaction().begin();
			session.merge(contact);
			session.getTransaction().commit();
		}
		catch(ContactsException exception)
		{
			exception.printStackTrace();
			throw exception;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw new ContactsException(ErrorCode.SERVICE_UNAVAILABLE);
		}
	}
}
