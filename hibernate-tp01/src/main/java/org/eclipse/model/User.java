package org.eclipse.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//import java.util.Date;

@Entity
public class User {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="profilid", referencedColumnName="id", nullable=false)
	private Profil profil;
//	private Date hiringDate;

	public User() {
		super();
	}
	
	public User(String nom, String prenom/*, Profil profil,  Date hiringDate*/) {
		super();
		this.nom = nom;
		this.prenom = prenom;
//		this.profil = profil;
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

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
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
		return "[" + id + "] " + nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase()
				+ prenom.substring(1).toLowerCase() + ", profil " + profil;
	}

}
