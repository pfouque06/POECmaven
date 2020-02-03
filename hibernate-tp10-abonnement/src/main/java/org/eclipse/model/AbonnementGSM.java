package org.eclipse.model;

import javax.persistence.Entity;

@Entity
public class AbonnementGSM extends Abonnement {

	private Integer fidelio;

	public Integer getFidelio() {
		return fidelio;
	}

	public void setFidelio(Integer fidelio) {
		this.fidelio = fidelio;
	}

	@Override
	public String toString() {
		return "GSM/fidelio(" + fidelio + ") : " + super.toString();
	}
	
	
}
