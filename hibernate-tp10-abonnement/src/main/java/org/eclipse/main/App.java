package org.eclipse.main;

import java.sql.Date;
import java.util.List;

import org.eclipse.models.*;
import org.hibernate.Criteria;
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
        /* creation ORM */
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Facture.class);
        configuration.addAnnotatedClass(FullName.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Abonnement.class);
        configuration.addAnnotatedClass(AbonnementGSM.class);
        configuration.addAnnotatedClass(AbonnementFixe.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        System.out.println();
		System.out.println("--- creation des Datas ---");
//        // factures
//        Facture f01 = new Facture();
//        f01.setDateFact(new Date(2020, 01, 01));
//        f01.setMontant(20);
//        f01.setReglee(true);
//        System.out.println(f01);
//        Facture f02 = new Facture();
//        f02.setDateFact(new Date(2020, 02, 01));
//        f02.setMontant(20);
//        f02.setReglee(false);
//        System.out.println(f02);
//        // client
//        FullName cName = new FullName();
//        cName.setNom("Soule");
//        cName.setPrenom("Sam");
//        Client c01 = new Client();
//        c01.setNom(cName);
//        c01.setEmail("ss@ss.com");
//        c01.setTel("060606060606");
//        c01.setVille("SSville");
//        System.out.println(c01);
//        // abo GSM
//        AbonnementGSM gsm01 = new AbonnementGSM();
//        gsm01.setFidelio(1);
//        gsm01.setNomAbonnement("Fidelio01");
//        gsm01.setDateAbonnement(new Date(2020, 01, 01));
//        gsm01.setSolde(0);
//        gsm01.setProp(c01);
//        gsm01.addFacture(f01);
//        System.out.println(gsm01);
//        // abo Fixe
//        AbonnementFixe fixe01 = new AbonnementFixe();
//        fixe01.setDebit(1);
//        fixe01.setNomAbonnement("Fixe01");
//        fixe01.setDateAbonnement(new Date(2020, 01, 01));
//        fixe01.setSolde(0);
//        fixe01.setProp(c01);
//        fixe01.addFacture(f02);
//        System.out.println(fixe01);
//        // persist
//        session.persist(gsm01);
//        session.persist(fixe01);
        
        // Getall
        Criteria criteria;
        System.out.println();
        System.out.println("----getAll Abonnements GSM---");
        criteria = session.createCriteria(AbonnementGSM.class);
        List<AbonnementGSM> aboGSM = (List<AbonnementGSM>) criteria.list();
        for (AbonnementGSM abo : aboGSM)
        	System.out.println(abo);
        
		System.out.println();
		System.out.println("----getAll Abonnements Fixe---");
		criteria = session.createCriteria(AbonnementFixe.class);
		List<AbonnementFixe> aboFixe = (List<AbonnementFixe>) criteria.list();
		for (AbonnementFixe abo : aboFixe)
			System.out.println(abo);
		


        
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
