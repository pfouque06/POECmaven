package org.eclipse.dao;

import org.eclipse.model.AbonnementGSM;
import org.hibernate.Session;

public class AbonnementGSMDao extends GenericDao<AbonnementGSM, Integer> {
	public AbonnementGSMDao(Session session) {
		super(AbonnementGSM.class, session);
	}
}
