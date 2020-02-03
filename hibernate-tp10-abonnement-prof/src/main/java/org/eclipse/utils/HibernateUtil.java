package org.eclipse.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		return configuration.buildSessionFactory();
	}
}
