package org.eclipse.main;

import java.util.List;

import org.eclipse.model.Personne;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Personne p1 = new Personne();
		p1.setNom("Soule");
		p1.setPrenom("Sam");
		Personne p2 = new Personne();
		p2.setNom("Cool");
		p2.setPrenom("Raoul");
		Personne p3 = new Personne();
		p3.setNom("Aleze");
		p3.setPrenom("Blaise");

		// configuration object instance and load src/main/java/hibernate.cfg.xml
		// Configuration config = new Configuration();
		// config.configure();
		Configuration config = new Configuration().configure();
		// add mapping class
		config.addAnnotatedClass(Personne.class);
		// Build entity manager factory from configuration object
		SessionFactory sessionFactory = config.buildSessionFactory();
		// get entity manager
		Session session = sessionFactory.openSession();
		// start transaction
		Transaction transaction = session.beginTransaction();

		// insert un objet Personne
		// session.persist(p1);
		// insert Personne and get ID
		// Integer id = (Integer) session.save(p1);
//        System.out.println((Integer) session.save(p1) + "");
		// terminate transsaction and close flow

//        session.persist(p2);
//        session.persist(p3);
//        session.flush();

		System.out.println();
		System.out.println("----display---");
		// display object with id 1 : with load() method
		System.out.println(session.load(Personne.class, 1));

		// display object with id 2 : with get() method
		System.out.println();
		Personne p = session.get(Personne.class, 2);
		System.out.println("original : " + p);

		System.out.println();
		System.out.println("----update---");
		// update object with id 2
		String pNnom = p.getNom();
		String pPrenom = p.getPrenom();
		p.setNom("Ban");
		p.setPrenom("Zaiii");
		session.flush(); // commit tous les changements !!!
		System.out.println("updated : " + session.load(Personne.class, 2));
		
		//restore object with id 2
		p.setNom(pNnom);
		p.setPrenom(pPrenom);
		session.persist(p); // commit uniquement l'objet p !!
		System.out.println("restored : " + session.load(Personne.class, 2));

		System.out.println();
		System.out.println("----delete---");
		// insert new object adnd get ID
		Personne p4 = new Personne();
		p4.setNom("Nom");
		p4.setPrenom("Prenom");
		int p4ID = (Integer) session.save(p4);
		System.out.println("insert de " + p4 + " à lindex : " + p4ID + "");

		// delete object with ID
		p = session.get(Personne.class, p4ID);
		System.out.println("trouvé " + p4ID + ": " + p);
		session.delete(p);
		System.out.println("deleted " + p4ID);

		try {
			System.out.println("deleted not committed !! " + session.load(Personne.class, p4ID));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleted confirmed !");
		}

		System.out.println();
		System.out.println("----getAll---");
		//Getall
		Criteria criteria = session.createCriteria(Personne.class);
		List<Personne> personnes = (List<Personne>) criteria.list();
		for (Personne personne : personnes)
			System.out.println(personne);
		
		System.out.println();
		System.out.println("----findby()---");
		//find by criteria
		//criteria = session.createCriteria(Personne.class);
		criteria = criteria.add(Restrictions.eq("nom", "Soule"));
		personnes = (List<Personne>) criteria.list();
		for (Personne personne : personnes)
			System.out.println(personne);
		
		System.out.println();
		System.out.println("----refresh()---");
		// refresh method
		//on suppose que John Wick avec un num 1 existe dans la BD
		p = session.load(Personne.class, 1);
		p.setNom("Travolta");
		session.refresh(p);
		System.out.println("le nom est " + p.getNom());
		// affiche le nom est Wick
		// si on supprime session.refresh(p); Travolta sera affiché

		System.out.println();
		System.out.println("----evict()---");
		//evict method
		p = session.load(Personne.class, 1);
		p.setNom("Travolta");
		session.evict(p); // p n’est plus géré par session
		session.flush();
		transaction.commit();
		Personne pother = session.load(Personne.class, 1);
		System.out.println("le nom de p est " + p.getNom());
		System.out.println("le nom en DB est " + pother.getNom());
		// affiche le nom est Wick
		 
		 
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
}
