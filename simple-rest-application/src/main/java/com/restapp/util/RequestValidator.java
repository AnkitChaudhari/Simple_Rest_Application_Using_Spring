package com.restapp.util;

import com.restapp.common.ErrorCode;
import com.restapp.exception.ContactsException;
import com.restapp.model.Contact;

public class RequestValidator {
	
	public static void validateContactForAdd(Contact contact) throws ContactsException
	{
		if(contact.getName().equals(null)||contact.getName().isEmpty())
			throw new ContactsException(ErrorCode.NAME_EMPTY);
		String[] name=contact.getName().split(" ");
		if(name.length!=2)
			throw new ContactsException(ErrorCode.NAME_FORMAT);
		if(contact.getEmail().equals(null)||contact.getEmail().isEmpty())
			throw new ContactsException(ErrorCode.EMAIL_EMPTY);
		if(contact.getNumber().equals(null)||contact.getNumber().isEmpty())
			throw new ContactsException(ErrorCode.NUMBER_EMPTY);
	}
	
	public static void validateContactForUpdate(Contact contact) throws ContactsException
	{
		if(contact.getId()==null)
			throw new ContactsException(ErrorCode.CONTACT_NOT_SELECTED);
		if(contact.getName().equals(null)||contact.getName().isEmpty())
			throw new ContactsException(ErrorCode.NAME_EMPTY);
		String[] name=contact.getName().split(" ");
		if(name.length!=2)
			throw new ContactsException(ErrorCode.NAME_FORMAT);
		if(contact.getEmail().equals(null)||contact.getEmail().isEmpty())
			throw new ContactsException(ErrorCode.EMAIL_EMPTY);
		if(contact.getNumber().equals(null)||contact.getNumber().isEmpty())
			throw new ContactsException(ErrorCode.NUMBER_EMPTY);
	}
}
