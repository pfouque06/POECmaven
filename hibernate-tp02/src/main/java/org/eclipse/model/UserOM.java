package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import java.util.Date;

@Entity
public class UserOM {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<ProfilOM> profiles = new ArrayList<ProfilOM>();
//	private Date hiringDate;

	public UserOM() {
		super();
	}

	public UserOM(String nom, String prenom/*, List<Profil> profiles ,  Date hiringDate*/) {
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

	public List<ProfilOM> getProfiles() {
		return profiles;
	}
	
	public void setProfiles(List<ProfilOM> profiles) {
		this.profiles = profiles;
	}
	
	public void addProfilOM(ProfilOM profil) {
		this.profiles.add(profil);
	}

	public void removeProfilOM(ProfilOM profil) {
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
		for(ProfilOM profil : profiles)
			profilesList += profil + "\n";
		
		return "UserOM[" + id + "] " + nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase()
				+ prenom.substring(1).toLowerCase() + ", profiles :\n" + profilesList;
	}


}
