package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {
	
	static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;
	
	//get session factory
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			serviceRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate/hibernate.cfg.xml")
	                .build();

	        sessionFactory = new MetadataSources( serviceRegistry )
	                    .buildMetadata()
	                    .buildSessionFactory();
		}
		return sessionFactory;
	}

}
