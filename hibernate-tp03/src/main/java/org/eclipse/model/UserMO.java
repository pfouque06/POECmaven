package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import java.util.Date;

@Entity
public class UserMO {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="profilid", referencedColumnName="id", nullable=false)
	private ProfilMO profil = new ProfilMO();
//	private Date hiringDate;

	public UserMO() {
		super();
	}

	public UserMO(String nom, String prenom/*, List<Profil> profiles ,  Date hiringDate*/) {
		super();
		this.nom = nom;
		this.prenom = prenom;
//		this.profiles = profiles;
//		this.hiringDate = hiringDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ProfilMO getProfil() {
		return profil;
	}
	
	public void setProfil(ProfilMO profil) {
		this.profil = profil;
	}


//	public Date getHiringDate() {
//		return hiringDate;
//	}
//
//	public void setHiringDate(Date hiringDate) {
//		this.hiringDate = hiringDate;
//	}



	@Override
	public String toString() {
		return "UserMO[" + id + "] " + nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase()
				+ prenom.substring(1).toLowerCase() + ", profilMO : " + profil;
	}


}
