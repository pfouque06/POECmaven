package org.eclipse.dao;

import org.eclipse.models.Abonnement;
import org.hibernate.Session;

public class AbonnementDAO extends GenericDao<Abonnement, Integer> {
	public AbonnementDAO(Session session) {
		super(Abonnement.class, session);
	}
}
