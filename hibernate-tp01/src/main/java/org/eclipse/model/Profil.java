package org.eclipse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profil {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libelle;

	public Profil() {
		super();
	}

	public Profil(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "[" + id + "] Profil " + libelle + " (code=" + code + ")";
	}


}
