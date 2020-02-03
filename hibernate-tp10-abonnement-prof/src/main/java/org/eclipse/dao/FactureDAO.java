package org.eclipse.dao;

import org.eclipse.models.Facture;
import org.hibernate.Session;

public class FactureDAO extends GenericDao<Facture, Integer> {
	public FactureDAO(Session session) {
		super(Facture.class, session);
	}
}