package org.eclipse.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ABOGSM")
public class AbonnementGSM extends Abonnement {
	private int fidelio;

	public int getFidelio() {
		return fidelio;
	}

	public void setFidelio(int fidelio) {
		this.fidelio = fidelio;
	}

	@Override
	public String toString() {
		return super.toString() + "AbonnementGSM [fidelio=" + fidelio + "]";
	}
}