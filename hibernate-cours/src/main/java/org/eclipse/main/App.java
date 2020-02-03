package org.eclipse.main;

import org.eclipse.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Personne p1 = new Personne();
        p1.setNom("Travolta");
        p1.setPrenom("John");
        
        
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
        //session.persist(p1);
        // insert Personne and get ID
        //Integer id = (Integer) session.save(p1);
        System.out.println((Integer) session.save(p1) + "");
        // terminate transsaction and close flow
        transaction.commit();
        session.close();
        sessionFactory.close();
        
    }
}
