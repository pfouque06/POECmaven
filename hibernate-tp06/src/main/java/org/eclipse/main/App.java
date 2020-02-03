package org.eclipse.main;

import org.eclipse.model.FullNameTP06;
import org.eclipse.model.PersonneTP06;
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
        /* FullName */
        FullNameTP06 nomComplet = new FullNameTP06();
        nomComplet.setNom("travolta");
        nomComplet.setPrenom("john");
        /* Personne */
        PersonneTP06 personne = new PersonneTP06();
        personne.setFullName(nomComplet);
        /* Persistance */
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(PersonneTP06.class);
        configuration.addAnnotatedClass(FullNameTP06.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(personne);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
