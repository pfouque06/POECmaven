package org.eclipse.dao;

import org.eclipse.model.Client;
import org.hibernate.Session;

public class ClientDao extends GenericDao<Client, Integer> {
	public ClientDao(Session session) {
		super(Client.class, session);
	}
}
