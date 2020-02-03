package org.eclipse.dao;

import org.eclipse.models.*;
import org.hibernate.Session;

public class ClientDAO extends GenericDao<Client, Integer> {
	public ClientDAO(Session session) {
		super(Client.class, session);
	}
}