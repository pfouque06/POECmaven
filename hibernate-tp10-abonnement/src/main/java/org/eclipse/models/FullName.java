package org.eclipse.models;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {
	private String nom;
	private String prenom;

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

	@Override
	public String toString() {
		return nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase() + prenom.substring(1).toLowerCase();
	}

}
