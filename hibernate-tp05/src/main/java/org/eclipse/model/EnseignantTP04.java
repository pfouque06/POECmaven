package org.eclipse.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "ENS")
public class EnseignantTP04 extends PersonneTP04 {
	private int salaire;

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
}
