package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.model.ProfilMM;
import org.eclipse.model.UserMM;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class AppMM {
	
	static Configuration config;
	static SessionFactory sessionFactory;
	
	public static ProfilMM getProfilbyCode(String code){
		// get entity manager and  start transaction
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria;
		List<ProfilMM> listeProfil;
		criteria = session.createCriteria(ProfilMM.class);
		criteria = criteria.add(Restrictions.eq("code", code));
		listeProfil = (List<ProfilMM>) criteria.list();
		// commit transactin and close session
		transaction.commit();
		session.close();
		
		if (listeProfil.size() > 1) {
			System.err.println("###Error : " + code + " has duplicated profiles ");
		}
		return listeProfil.get(0);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// configuration object instance and load src/main/java/hibernate.cfg.xml
		// Configuration config = new Configuration();
		// config.configure();
		config = new Configuration().configure();
		// add mapping class
		config.addAnnotatedClass(ProfilMM.class);
		config.addAnnotatedClass(UserMM.class);
		// Build entity manager factory from configuration object
		sessionFactory = config.buildSessionFactory();
		// get entity manager
		Session session = sessionFactory.openSession();
		// start transaction
		Transaction transaction = session.beginTransaction();

		System.out.println("--- La liste des profiles ---");
		ProfilMM profilCP = new ProfilMM("CP", "Chef de Projet");
		ProfilMM profilMN = new ProfilMM("MN", "Manager");
		ProfilMM profilDP = new ProfilMM("DP", "Développeur");
		ProfilMM profilRH = new ProfilMM("RH", "Ressource Humaine");
		
//		session.persist(profilCP);
//		session.persist(profilMN);
//		session.persist(profilDP);
//		session.persist(profilRH);
//		System.out.println((Integer) session.save(profilCP) + "");
//		System.out.println((Integer) session.save(profilMN) + "");
//		System.out.println((Integer) session.save(profilDP) + "");
//		System.out.println((Integer) session.save(profilRH) + "");

		List<ProfilMM> profiles = new ArrayList<ProfilMM>();
		profiles.add(profilCP);
		profiles.add(profilDP);
		profiles.add(profilMN);
		profiles.add(profilRH);
		for (ProfilMM profil : profiles)
			System.out.println(profil);

		System.out.println();
		System.out.println("--- Récupération des profiles ---");

		profilDP = getProfilbyCode(profilDP.getCode());
		System.out.println(profilDP);
		
		profilCP = getProfilbyCode(profilCP.getCode());
		System.out.println(profilCP);

		profilMN = getProfilbyCode(profilMN.getCode());
		System.out.println(profilMN);
		
		profilRH = getProfilbyCode(profilRH.getCode());
		System.out.println(profilRH);
		
		System.out.println();
		System.out.println("--- La liste des profiles mis à jour---");
		profiles.clear();
		profiles.add(profilCP);
		profiles.add(profilDP);
		profiles.add(profilMN);
		profiles.add(profilRH);
		for (ProfilMM profil : profiles)
			System.out.println(profil);
		
		System.out.println();
		System.out.println("--- La liste des users ---");
//		System.out.println();
//		profiles.forEach(System.out::println);

//		System.out.println("--- La liste des users ---");
//		UserMM u1 = new UserMM("Mister", "Magoo");
//		u1.addProfilMM(profilMN);
//		u1.addProfilMM(profilCP);
//		UserMM u2 = new UserMM("Jackson", "Five");
//		u2.addProfilMM(profilDP);
//		u2.addProfilMM(profilMN);
//		UserMM u3 = new UserMM("Raoul", "saroule");
//		u3.addProfilMM(profilDP);
//		u3.addProfilMM(profilMN);
//		u3.addProfilMM(profilCP);
//		UserMM u4 = new UserMM("Relax", "Max");
//		u4.addProfilMM(profilCP);
//		u4.addProfilMM(profilMN);
//		UserMM u5 = new UserMM("Tranquille", "Emile");
//		u5.addProfilMM(profilDP);
//		u5.addProfilMM(profilMN);
//		UserMM u6 = new UserMM("Aleze", "Blaise");
//		u6.addProfilMM(profilMN);
//		u6.addProfilMM(profilCP);
//		u6.addProfilMM(profilDP);
//		List<User> utilisateurs = new ArrayList<>();
//		utilisateurs.add(u1);
//		utilisateurs.add(u2);
//		utilisateurs.add(u3);
//		utilisateurs.add(u4);
//		utilisateurs.add(u5);
//		utilisateurs.add(u6);
		
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

		System.out.println();
		System.out.println("--- nouveau user avec profils connus ---");
//		UserMM u = new UserMM("Hill", "Billy");
//		u.addProfilMM(profilDP);
//		u.addProfilMM(profilCP);
//		u.addProfilMM(profilMN);
//		session.persist(u);
//		UserMM u = new UserMM("Gros", "Bastard");
//		u.addProfilMM(profilRH);
//		u.addProfilMM(profilCP);
//		session.persist(u);
//		UserMM u = new UserMM("Petit", "trouduk");
//		u.addProfilMM(profilRH);
//		session.persist(u);
		
		// commit transactin and close session
		transaction.commit();
		session.close();
		
		// open session and begin transaction
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		System.out.println();
		System.out.println("----getAll Profils---");
		// Getall
		Criteria criteria = session.createCriteria(ProfilMM.class);
		profiles = (List<ProfilMM>) criteria.list();
		for (ProfilMM profil : profiles)
			System.out.println(profil);
		
		System.out.println();
		System.out.println("----getAll Users---");
		//Getall
		criteria = session.createCriteria(UserMM.class);
		List<UserMM> users = (List<UserMM>) criteria.list();
		for (UserMM user : users)
			System.out.println(user);


		// terminate transaction and close flow
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
