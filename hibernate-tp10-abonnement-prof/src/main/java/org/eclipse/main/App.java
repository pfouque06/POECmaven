package org.eclipse.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.dao.AbonnementDAO;
import org.eclipse.dao.ClientDAO;
import org.eclipse.dao.FactureDAO;
import org.eclipse.models.*;
import org.eclipse.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Client c = new Client();
		c.setNom("Jean Baton");
		c.setEmail("jb@f.fr");
		c.setTel("0443125473");
		c.setVille("Aurec-sur-Loire");
		ClientDAO cDAO = new ClientDAO(session);
		cDAO.save(c);
		System.out.println(c);
		Facture f1 = new Facture();
		f1.setDateFact(new Date("01/29/2018"));
		f1.setMontant(25.9f);
		f1.setReglee(true);
		Facture f2 = new Facture();
		f2.setDateFact(new Date("02/29/2018"));
		f2.setMontant(25.9f);
		f2.setReglee(false);
		Facture f3 = new Facture();
		f3.setDateFact(new Date("01/29/2018"));
		f3.setMontant(20.9f);
		f3.setReglee(true);
		Facture f4 = new Facture();
		f4.setDateFact(new Date("02/29/2018"));
		f4.setMontant(20.9f);
		f4.setReglee(false);
		FactureDAO fDAO = new FactureDAO(session);
		fDAO.save(f1);
		fDAO.save(f2);
		fDAO.save(f3);
		fDAO.save(f4);
		List<Facture> facturesAboFIXE = new ArrayList<Facture>();
		facturesAboFIXE.add(f1);
		facturesAboFIXE.add(f2);
		List<Facture> facturesAboGSM = new ArrayList<Facture>();
		facturesAboGSM.add(f3);
		facturesAboGSM.add(f4);
		//facturesAboGSM.forEach(System.out::println);
		for(Facture facture : facturesAboGSM) 
			System.out.println(facture);
		AbonnementFixe aboFixe = new AbonnementFixe();
		aboFixe.setClient(c);
		aboFixe.setDateAbonnement(new Date("01/12/2018"));
		aboFixe.setNomAbonnement("Premium ABOFIXE");
		aboFixe.setLesFactures(facturesAboFIXE);
		aboFixe.setDebit(10);
		System.out.println(aboFixe);
		AbonnementGSM aboGSM = new AbonnementGSM();
		aboGSM.setClient(c);
		aboGSM.setDateAbonnement(new Date("01/12/2018"));
		aboGSM.setNomAbonnement("Premium ABOGSM");
		aboGSM.setLesFactures(facturesAboGSM);
		aboGSM.setFidelio(2);
		System.out.println(aboGSM);
		AbonnementDAO aDAO = new AbonnementDAO(session);
		aDAO.save(aboGSM);
		aDAO.save(aboFixe);
		Abonnement abo1 = aDAO.findById(6);
		System.out.println(abo1);
		Abonnement abo2 = aDAO.findById(7);
		System.out.println(abo2);
	}
}