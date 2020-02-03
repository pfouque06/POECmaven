package org.eclipse.main;

import java.util.List;

import org.eclipse.model.ProfilMO;
import org.eclipse.model.UserMO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppMO {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// configuration object instance and load src/main/java/hibernate.cfg.xml
		// Configuration config = new Configuration();
		// config.configure();
		Configuration config = new Configuration().configure();
		// add mapping class
		config.addAnnotatedClass(ProfilMO.class);
		config.addAnnotatedClass(UserMO.class);
		// Build entity manager factory from configuration object
		SessionFactory sessionFactory = config.buildSessionFactory();
		// get entity manager
		Session session = sessionFactory.openSession();
		// start transaction
		Transaction transaction = session.beginTransaction();

		System.out.println("--- La liste des profiles ---");
		ProfilMO profilCP = new ProfilMO("CP", "Chef de Projet");
		ProfilMO profilMN = new ProfilMO("MN", "Manager");
		ProfilMO profilDP = new ProfilMO("DP", "Développeur");
		
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
		UserMO u1 = new UserMO("Mister", "Magoo");
		u1.setProfil(profilMN);
		UserMO u2 = new UserMO("Jackson", "Five");
		u2.setProfil(profilMN);
		UserMO u3 = new UserMO("Raoul", "saroule");
		u3.setProfil(profilDP);
		UserMO u4 = new UserMO("Relax", "Max");
		u4.setProfil(profilDP);
		UserMO u5 = new UserMO("Tranquille", "Emile");
		u5.setProfil(profilCP);
		UserMO u6 = new UserMO("Aleze", "Blaise");
		u6.setProfil(profilCP);
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
		Criteria criteria = session.createCriteria(ProfilMO.class);
		List<ProfilMO> profiles = (List<ProfilMO>) criteria.list();
		for (ProfilMO profil : profiles)
			System.out.println(profil);
		
		System.out.println();
		System.out.println("----getAll Users---");
		//Getall
		criteria = session.createCriteria(UserMO.class);
		List<UserMO> users = (List<UserMO>) criteria.list();
		for (UserMO user : users)
			System.out.println(user);


		// terminate transaction and close flow
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
