package com.restapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

public class EntityManagerFactory {
	
	protected Session getEntityManager()
	{
		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		return session;
	}

}
