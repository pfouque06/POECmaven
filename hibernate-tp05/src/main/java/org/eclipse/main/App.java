package org.eclipse.main;

import org.eclipse.model.EnseignantTP04;
import org.eclipse.model.EtudiantTP04;
import org.eclipse.model.PersonneTP04;
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
        /* Personne */
        PersonneTP04 personne = new PersonneTP04();
        personne.setNom("Guardiola");
        personne.setPrenom("Pep");
        /* Enseignant */
        EnseignantTP04 enseignant = new EnseignantTP04();
        enseignant.setNom("Ferguson");
        enseignant.setPrenom("Sir");
        enseignant.setSalaire(10000);
        /* étudiant */
        EtudiantTP04 etudiant = new EtudiantTP04();
        etudiant.setNom("Mourinho");
        etudiant.setPrenom("Jose");
        etudiant.setNiveau("Ligue 1");
        /* Persistance */
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(PersonneTP04.class);
        configuration.addAnnotatedClass(EnseignantTP04.class);
        configuration.addAnnotatedClass(EtudiantTP04.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(personne);
        session.persist(etudiant);
        session.persist(enseignant);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
