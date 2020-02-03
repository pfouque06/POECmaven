package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import java.util.Date;

@Entity
public class UserMM {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<ProfilMM> profiles = new ArrayList<ProfilMM>();
//	private Date hiringDate;

	public UserMM() {
		super();
	}

	public UserMM(String nom, String prenom/*, List<Profil> profiles ,  Date hiringDate*/) {
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

	public List<ProfilMM> getProfiles() {
		return profiles;
	}
	
	public void setProfiles(List<ProfilMM> profiles) {
		this.profiles = profiles;
	}
	
	public void addProfilMM(ProfilMM profil) {
		this.profiles.add(profil);
	}

	public void removeProfilMM(ProfilMM profil) {
		this.profiles.remove(profil);
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
		String profilesList = "";
		for(ProfilMM profil : profiles)
			profilesList += profil + "\n";
		
		return "UserMM[" + id + "] " + nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase()
				+ prenom.substring(1).toLowerCase() + ", profiles :\n" + profilesList;
	}


}
