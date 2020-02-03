package org.eclipse.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Abonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // for TABLE_PER_CLASS inheritance ORM model
	private Integer idAbonnement;
	private String nomAbonnement;
	private Date dateAbonnement;
	private float solde;
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="clientid", referencedColumnName="idClient", nullable=false)
	private Client prop;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Facture> lesFactures = new ArrayList<Facture>();;
	
	public Abonnement() {
		super();
	}

	public Integer getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(Integer idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	public String getNomAbonnement() {
		return nomAbonnement;
	}

	public void setNomAbonnement(String nomAbonnement) {
		this.nomAbonnement = nomAbonnement;
	}

	public Date getDateAbonnement() {
		return dateAbonnement;
	}

	public void setDateAbonnement(Date dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Client getProp() {
		return prop;
	}

	public void setProp(Client prop) {
		this.prop = prop;
	}

	public List<Facture> getLesFactures() {
		return lesFactures;
	}

	public void setLesFactures(List<Facture> lesFactures) {
		this.lesFactures = lesFactures;
	}

	public void addFacture(Facture facture) {
		this.lesFactures.add(facture);
	}

	public void removeFacture(Facture facture) {
		this.lesFactures.remove(facture);
	}

	@Override
	public String toString() {
		
		String listefactures = "";
		for(Facture facture : lesFactures)
			listefactures += facture + "\n";
		
		return "[" + idAbonnement + "] nomAbonnement=" + nomAbonnement + ", dateAbonnement="
				+ dateAbonnement + ", solde=" + solde + "\n" + prop + "\n" + listefactures ;
	}
	
	
	
	
}
