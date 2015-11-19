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
	public List<UserContact> getAllContacts() {
		Query query = getEntityManager().createQuery("FROM UserContact");
		return query.list();
	}

	@Override
	public boolean addContact(UserContact contact) {
		boolean status = false;
		try {
			Session session = getEntityManager();
			session.getTransaction().begin();
			session.persist(contact);
			session.getTransaction().commit();
			status = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteContact(Integer id) {
		boolean status = false;
		try {
			Session session = getEntityManager();
			UserContact contact = (UserContact) session.load(UserContact.class,
					id);
			session.getTransaction().begin();
			session.delete(contact);
			session.getTransaction().commit();
			status = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return status;
	}

	@Override
	public UserContact getContactById(Integer id) throws ContactsException {
		UserContact contact = null;
		try {
			contact = (UserContact) getEntityManager().load(UserContact.class,
					id);
			if(contact==null)
			{
				throw new ContactsException(ErrorCode.CONTACT_NOT_FOUND);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ContactsException(ErrorCode.SERVICE_UNAVAILABLE);
		}
		return contact;
	}

	@Override
	public boolean updateContact(UserContact contact) {
		boolean status = false;
		try {
			Session session = getEntityManager();
			session.getTransaction().begin();
			session.merge(contact);
			session.getTransaction().commit();
			status = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return status;
	}
}
