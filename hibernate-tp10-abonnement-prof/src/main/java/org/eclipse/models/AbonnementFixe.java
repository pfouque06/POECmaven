package org.eclipse.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ABOFIXE")
public class AbonnementFixe extends Abonnement {
	private int debit;

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	@Override
	public String toString() {
		return super.toString() + "AbonnementFixe [debit=" + debit + "]";
	}
}
