package org.eclipse.dao;

import org.eclipse.model.AbonnementFixe;
import org.hibernate.Session;

public class AbonnementFixeDao extends GenericDao<AbonnementFixe, Integer> {
	public AbonnementFixeDao(Session session) {
		super(AbonnementFixe.class, session);
	}
}
