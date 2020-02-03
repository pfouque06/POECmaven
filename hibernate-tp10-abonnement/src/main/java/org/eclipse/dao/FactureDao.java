package org.eclipse.dao;

import org.eclipse.models.Facture;
import org.hibernate.Session;

public class FactureDao extends GenericDao<Facture, Integer> {
	public FactureDao(Session session) {
		super(Facture.class, session);
	}
}
