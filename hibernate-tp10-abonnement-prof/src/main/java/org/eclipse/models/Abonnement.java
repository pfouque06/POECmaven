package org.eclipse.models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ABO")
@DiscriminatorValue(value = "ABO")
public class Abonnement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAbonnement;
	private String nomAbonnement;
	private Date dateAbonnement;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false)
	private Client client;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Facture> lesFactures;

	public Abonnement() {
		super();
	}

	public Abonnement(String nomAbonnement, Date dateAbonnement, Client client, List<Facture> lesFactures) {
		super();
		this.nomAbonnement = nomAbonnement;
		this.dateAbonnement = dateAbonnement;
		this.client = client;
		this.lesFactures = lesFactures;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Facture> getLesFactures() {
		return lesFactures;
	}

	public void setLesFactures(List<Facture> lesFactures) {
		this.lesFactures = lesFactures;
	}

	@Override
	public String toString() {
		return "Abonnement [nomAbonnement=" + nomAbonnement + ", dateAbonnement=" + dateAbonnement + ", client="
				+ client + ", lesFactures=" + lesFactures + "]";
	}
}