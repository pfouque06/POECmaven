package org.eclipse.model;

import javax.persistence.Entity;

@Entity
public class AbonnementFixe extends Abonnement {

	private Integer debit;

	public Integer getDebit() {
		return debit;
	}

	public void setDebit(Integer debit) {
		this.debit = debit;
	}

	@Override
	public String toString() {
		return "Fixe/debit(" + debit + ") : " + super.toString();
	}
	
	
}
