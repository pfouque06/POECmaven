package org.eclipse.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFact;
	private Date dateFact;
	private float montant;
	private boolean reglee;

	public Facture() {
		super();
	}

	public Facture(Date dateFact, float montant, boolean reglee) {
		super();
		this.dateFact = dateFact;
		this.montant = montant;
		this.reglee = reglee;
	}

	public Integer getIdFact() {
		return idFact;
	}

	public void setIdFact(Integer idFact) {
		this.idFact = idFact;
	}

	public Date getDateFact() {
		return dateFact;
	}

	public void setDateFact(Date dateFact) {
		this.dateFact = dateFact;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public boolean isReglee() {
		return reglee;
	}

	public void setReglee(boolean reglee) {
		this.reglee = reglee;
	}

	@Override
	public String toString() {
		return "Facture [dateFact=" + dateFact + ", montant=" + montant + ", reglee=" + reglee + "]";
	}
}