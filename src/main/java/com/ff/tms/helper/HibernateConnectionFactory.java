package com.ff.tms.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateConnectionFactory {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	
	static {
		
		factory = Persistence.createEntityManagerFactory("taskmanagement");
		manager = factory.createEntityManager();
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}

	public static EntityManager getManager() {
		return manager;
	}

}
