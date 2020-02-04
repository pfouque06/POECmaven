package org.eclipse.main;

import java.util.Date;
import java.util.List;

import org.eclipse.dao.*;
import org.eclipse.models.*;
import org.eclipse.utils.HibernateUtil;
import org.hibernate.Session;

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
        AbonnementDao abonnementDao = new AbonnementDao(session);
        
        System.out.println();
        System.out.println("--- creation des Datas ---");

		// client
        System.out.println();
		System.out.println("--- creation des Clients ---");
//		FullName cName01 = new FullName();
//		cName01.setNom("Soule");
//		cName01.setPrenom("Sam");
//		Client c01 = new Client();
//		c01.setNom(cName01);
//		c01.setEmail("ss@ss.com");
//		c01.setTel("0606060606");
//		c01.setVille("SSville");
//		System.out.println(c01);
//
//		FullName cName02 = new FullName();
//		cName02.setNom("Chie");
//		cName02.setPrenom("Jean");
//		Client c02 = new Client();
//		c02.setNom(cName02);
//		c02.setEmail("jc@jc.com");
//		c02.setTel("0707070707");
//		c02.setVille("JCville");
//		System.out.println(c02);
		
		// persist
//		System.out.println(clientDAO.save(c01));
//		System.out.println(clientDAO.save(c02));
        
		List<Client> clients = clientDAO.findAll();
		clients.forEach(System.out::println);
        //for (Client client : clients)
        //	System.out.println(client);
		
        // factures
        System.out.println();
        System.out.println("--- creation des Factures ---");
//        Facture f01 = new Facture();
//        f01.setDateFact(new Date("01/20/2020"));
//        f01.setMontant(15.99f);
//        f01.setReglee(true);
//        System.out.println(f01);
//        
//		Facture f02 = new Facture();
//		f02.setDateFact(new Date("02/20/2020"));
//		f02.setMontant(25.99f);
//		f02.setReglee(false);
//		System.out.println(f02);
//		
//		Facture f03 = new Facture();
//		f03.setDateFact(new Date("03/20/2020"));
//		f03.setMontant(35.99f);
//		f03.setReglee(false);
//		System.out.println(f03);
//		
//        Facture f04 = new Facture();
//        f04.setDateFact(new Date("04/20/2020"));
//        f04.setMontant(45.99f);
//        f04.setReglee(false);
//        System.out.println(f04);

        // persist
//        System.out.println(factureDAO.save(f01));
//        System.out.println(factureDAO.save(f02));
//        System.out.println(factureDAO.save(f03));
//        System.out.println(factureDAO.save(f04));
       
        List<Facture> factures = factureDAO.findAll();
        factures.forEach(System.out::println);
        //for (Facture facture : factures)
        //	System.out.println(facture);
        
        //get client
        System.out.println();
        System.out.println("--- get Client by ID ---");
        Client client = clientDAO.findById(2);
        System.out.println(client);
        
        //get facture
        System.out.println();
        System.out.println("--- get Facture by ID ---");
        Facture facture = factureDAO.findById(2);
        System.out.println(facture);

        
        // abo GSM
        System.out.println();
        System.out.println("--- creation des abo ---");
		// set NEW facture
//		Facture f05 = new Facture();
//		f05.setDateFact(new Date("05/20/2020"));
//		f05.setMontant(49.99f);
//		f05.setReglee(true);
//		System.out.println(f05);
//		System.out.println(factureDAO.save(f05));
//		factureDAO.save(f05);
		// create aboGSM
//        AbonnementGSM gsm01 = new AbonnementGSM();
//        gsm01.setFidelio(10);
//        gsm01.setNomAbonnement("Fidelio Premium");
//        gsm01.setDateAbonnement(new Date("01/30/2020"));
//        gsm01.setSolde(100);
//        gsm01.setProp(c01);
//        gsm01.addFacture(f01);
//        gsm01.addFacture(f03);
//        System.out.println(gsm01);
//        System.out.println(abonnementDao.save(gsm01));
//        
//		AbonnementGSM gsm02 = new AbonnementGSM();
//		gsm02.setFidelio(10);
//		gsm02.setNomAbonnement("Fidelio Base");
//		gsm02.setDateAbonnement(new Date("03/30/2020"));
//		gsm02.setSolde(0);
//		gsm02.setProp(c02);
////		gsm02.addFacture(f01);
////		gsm02.addFacture(f03);
//        System.out.println(gsm02);
//        System.out.println(abonnementDao.save(gsm02));
        
        // abo Fixe
//        AbonnementFixe fixe01 = new AbonnementFixe();
//        fixe01.setDebit(1000);
//        fixe01.setNomAbonnement("Fixette Premium");
//        fixe01.setDateAbonnement(new Date("02/30/2020"));
//        fixe01.setSolde(20);
//        fixe01.setProp(c01);
//        fixe01.addFacture(f02);
//        fixe01.addFacture(f04);
//        System.out.println(fixe01);
//        System.out.println(abonnementDao.save(fixe01));
//        
//        AbonnementFixe fixe02 = new AbonnementFixe();
//        fixe02.setDebit(100);
//        fixe02.setNomAbonnement("Fixette Base");
//        fixe02.setDateAbonnement(new Date("04/30/2020"));
//        fixe02.setSolde(20);
//        fixe02.setProp(c02);
////        fixe02.addFacture(f02);
////        fixe02.addFacture(f04);
//        System.out.println(fixe02);
//        System.out.println(abonnementDao.save(fixe02));
  
        // Getall
        System.out.println();
        System.out.println("----getAll Abonnements GSM---");
        List<Abonnement> abo = abonnementDao.findAll();
        abo.forEach(System.out::println);
        //for (Abonnement abo : aboGSM)
        //	System.out.println(abo);
        
//		System.out.println();
//		System.out.println("----getAll Abonnements Fixe---");
//        List<Abonnement> aboFixe = abonnementDao.findAll();
//        for (Abonnement abo : aboFixe)
//        	System.out.println(abo);

        session.close();
        HibernateUtil.close();
    }
}
