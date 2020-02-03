package org.eclipse.dao;

import org.eclipse.models.Abonnement;
import org.hibernate.Session;

public class AbonnementDao extends GenericDao<Abonnement, Integer> {
	public AbonnementDao(Session session) {
		super(Abonnement.class, session);
	}
}
