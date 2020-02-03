package org.eclipse.main;

import java.util.List;

import org.eclipse.model.Profil;
import org.eclipse.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppOO {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// configuration object instance and load src/main/java/hibernate.cfg.xml
		// Configuration config = new Configuration();
		// config.configure();
		Configuration config = new Configuration().configure();
		// add mapping class
		config.addAnnotatedClass(Profil.class);
		config.addAnnotatedClass(User.class);
		// Build entity manager factory from configuration object
		SessionFactory sessionFactory = config.buildSessionFactory();
		// get entity manager
		Session session = sessionFactory.openSession();
		// start transaction
		Transaction transaction = session.beginTransaction();

		System.out.println("--- La liste des profiles ---");
		Profil profilCP = new Profil("CP", "Chef de Projet");
		Profil profilMN = new Profil("MN", "Manager");
		Profil profilDP = new Profil("DP", "Développeur");
		
//		session.persist(profilCP);
//		session.persist(profilMN);
//		session.persist(profilDP);
//		System.out.println((Integer) session.save(profilCP) + "");
//		System.out.println((Integer) session.save(profilMN) + "");
//		System.out.println((Integer) session.save(profilDP) + "");
		
//		List<Profil> profiles = new ArrayList<>();
//		profiles.add(profilDP);
//		profiles.add(profilMN);
//		profiles.add(profilCP);
		
		//session.flush();
		
//		System.out.println("--- La liste des profiles ---");
//		System.out.println();
//		profiles.forEach(System.out::println);

		System.out.println("--- La liste des users ---");
		User u1 = new User("Mister", "Magoo");
		u1.setProfil(profilMN);
		User u2 = new User("Jackson", "Five");
		u2.setProfil(profilDP);
		User u3 = new User("Raoul", "saroule");
		u3.setProfil(profilCP);
		User u4 = new User("Relax", "Max");
		u4.setProfil(profilCP);
		User u5 = new User("Tranquille", "Emile");
		u5.setProfil(profilDP);
		User u6 = new User("Aleze", "Blaise");
		u6.setProfil(profilMN);
//		List<User> utilisateurs = new ArrayList<>();
//		utilisateurs.add(u1);
//		utilisateurs.add(u2);
//		utilisateurs.add(u3);
//		utilisateurs.add(u4);
//		utilisateurs.add(u5);
//		utilisateurs.add(u6);
		

		// insert un objet Personne
		// session.persist(p1);
		// insert Personne and get ID
		// Integer id = (Integer) session.save(p1);
//		session.persist(u1);
//		session.persist(u2);
//		session.persist(u3);
//		session.persist(u4);
//		session.persist(u5);
//		session.persist(u6);
//		System.out.println((Integer) session.save(u1) + "");
//		System.out.println((Integer) session.save(u2) + "");
//		System.out.println((Integer) session.save(u3) + "");
//		System.out.println((Integer) session.save(u4) + "");
//		System.out.println((Integer) session.save(u5) + "");
//		System.out.println((Integer) session.save(u6) + "");
		
		
		// commit transactin and close session
		transaction.commit();
		session.close();
		
		// open session and begin transaction
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		System.out.println();
		System.out.println("----getAll Profils---");
		// Getall
		Criteria criteria = session.createCriteria(Profil.class);
		List<Profil> profiles = (List<Profil>) criteria.list();
		for (Profil profil : profiles)
			System.out.println(profil);
		
		System.out.println();
		System.out.println("----getAll Users---");
		//Getall
		criteria = session.createCriteria(User.class);
		List<User> users = (List<User>) criteria.list();
		for (User user : users)
			System.out.println(user);


		// terminate transaction and close flow
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
