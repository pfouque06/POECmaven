package org.eclipse.config;

import org.eclipse.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Facture.class);
		configuration.addAnnotatedClass(FullName.class);
		configuration.addAnnotatedClass(Client.class);
		configuration.addAnnotatedClass(Abonnement.class);
		configuration.addAnnotatedClass(AbonnementGSM.class);
		configuration.addAnnotatedClass(AbonnementFixe.class);
		sessionFactory = configuration.buildSessionFactory();
		return configuration.buildSessionFactory();
	}

	public static void close() {
		sessionFactory.close();
	}
}
