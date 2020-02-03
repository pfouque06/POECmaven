package org.eclipse.main;

import java.sql.Date;
import java.util.List;

import org.eclipse.config.HibernateUtil;
import org.eclipse.dao.*;
import org.eclipse.model.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class AppDAO 
{
    public static void main( String[] args ) throws Exception {
    	
        System.out.println( "Hello World!" );
        /* creation ORM */
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClientDao clientDAO = new ClientDao(session);
        FactureDao factureDAO = new FactureDao(session);
        AbonnementGSMDao abonnementGSMDao = new AbonnementGSMDao(session);
        AbonnementFixeDao abonnementFixeDao = new AbonnementFixeDao(session);
        
        System.out.println();
        System.out.println("--- creation des Datas ---");

		// client
        System.out.println();
		System.out.println("--- creation des Clients ---");
//		FullName cName = new FullName();
//		cName.setNom("Chie");
//		cName.setPrenom("Jean");
//		Client c01 = new Client();
//		c01.setNom(cName);
//		c01.setEmail("jc@jc.com");
//		c01.setTel("0707070707");
//		c01.setVille("JCville");
//		System.out.println(c01);
//		System.out.println(clientDAO.save(c01));
        
		List<Client> clients = clientDAO.findAll();
        for (Client client : clients)
        	System.out.println(client);
		
        // factures
        System.out.println();
        System.out.println("--- creation des Factures ---");
//        Facture f01 = new Facture();
//        f01.setDateFact(new Date(2020, 03, 01));
//        f01.setMontant(30);
//        f01.setReglee(true);
//        System.out.println(f01);
//		System.out.println(factureDAO.save(f01));
//        
//        Facture f02 = new Facture();
//        f02.setDateFact(new Date(2020, 04, 01));
//        f02.setMontant(40);
//        f02.setReglee(false);
//        System.out.println(f02);
//        System.out.println(factureDAO.save(f02));
       
        List<Facture> factures = factureDAO.findAll();
        for (Facture facture : factures)
        	System.out.println(facture);
        
        //get client
        System.out.println();
        System.out.println("--- get Client by ID ---");
        Client c01 = clientDAO.findById(2);
        System.out.println(c01);

        
        // abo GSM
        System.out.println();
        System.out.println("--- creation des abo ---");
		// set NEW facture
		// Facture f01 = factureDAO.findById(2);
		Facture f01 = new Facture();
		f01.setDateFact(new Date(2020, 03, 01));
		f01.setMontant(50);
		f01.setReglee(true);
		System.out.println(f01);
//		System.out.println(factureDAO.save(f01));
		factureDAO.save(f01);
		// create aboGSM
//		AbonnementGSM gsm01 = new AbonnementGSM();
//        gsm01.setFidelio(1);
//        gsm01.setNomAbonnement("Fidelio01");
//        gsm01.setDateAbonnement(new Date(2020, 01, 01));
//        gsm01.setSolde(0);
//        gsm01.setProp(c01);
//        gsm01.addFacture(f01);
//        System.out.println(gsm01);
//        System.out.println(abonnementGSMDao.save(gsm01));
        
        // abo Fixe
        AbonnementFixe fixe01 = new AbonnementFixe();
        fixe01.setDebit(1);
        fixe01.setNomAbonnement("Fixe01");
        fixe01.setDateAbonnement(new Date(2020, 01, 01));
        fixe01.setSolde(0);
        fixe01.setProp(c01);
        fixe01.addFacture(f01);
        System.out.println(fixe01);
        abonnementFixeDao.save(fixe01);
//       
        // Getall
        System.out.println();
        System.out.println("----getAll Abonnements GSM---");
        List<AbonnementGSM> aboGSM = abonnementGSMDao.findAll();
        for (AbonnementGSM abo : aboGSM)
        	System.out.println(abo);
        
		System.out.println();
		System.out.println("----getAll Abonnements Fixe---");
        List<AbonnementFixe> aboFixe = abonnementFixeDao.findAll();
        for (AbonnementFixe abo : aboFixe)
        	System.out.println(abo);

        session.close();
//        HibernateUtil.close();
    }
}
