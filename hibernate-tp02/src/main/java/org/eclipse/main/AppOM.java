package org.eclipse.main;

import java.util.List;

import org.eclipse.model.ProfilOM;
import org.eclipse.model.UserOM;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppOM {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// configuration object instance and load src/main/java/hibernate.cfg.xml
		// Configuration config = new Configuration();
		// config.configure();
		Configuration config = new Configuration().configure();
		// add mapping class
		config.addAnnotatedClass(ProfilOM.class);
		config.addAnnotatedClass(UserOM.class);
		// Build entity manager factory from configuration object
		SessionFactory sessionFactory = config.buildSessionFactory();
		// get entity manager
		Session session = sessionFactory.openSession();
		// start transaction
		Transaction transaction = session.beginTransaction();

		System.out.println("--- La liste des profiles ---");
		ProfilOM profilCP = new ProfilOM("CP", "Chef de Projet");
		ProfilOM profilMN = new ProfilOM("MN", "Manager");
		ProfilOM profilDP = new ProfilOM("DP", "Développeur");
		
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
		UserOM u1 = new UserOM("Mister", "Magoo");
		u1.addProfilOM(profilMN);
		u1.addProfilOM(profilCP);
		UserOM u2 = new UserOM("Jackson", "Five");
		u2.addProfilOM(profilDP);
		u2.addProfilOM(profilMN);
		UserOM u3 = new UserOM("Raoul", "saroule");
		u3.addProfilOM(profilDP);
		u3.addProfilOM(profilMN);
		u3.addProfilOM(profilCP);
		UserOM u4 = new UserOM("Relax", "Max");
		u4.addProfilOM(profilCP);
		u4.addProfilOM(profilMN);
		UserOM u5 = new UserOM("Tranquille", "Emile");
		u5.addProfilOM(profilDP);
		u5.addProfilOM(profilMN);
		UserOM u6 = new UserOM("Aleze", "Blaise");
		u6.addProfilOM(profilMN);
		u6.addProfilOM(profilCP);
		u6.addProfilOM(profilDP);
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
		session.persist(u3);
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
		Criteria criteria = session.createCriteria(ProfilOM.class);
		List<ProfilOM> profiles = (List<ProfilOM>) criteria.list();
		for (ProfilOM profil : profiles)
			System.out.println(profil);
		
		System.out.println();
		System.out.println("----getAll Users---");
		//Getall
		criteria = session.createCriteria(UserOM.class);
		List<UserOM> users = (List<UserOM>) criteria.list();
		for (UserOM user : users)
			System.out.println(user);


		// terminate transaction and close flow
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
