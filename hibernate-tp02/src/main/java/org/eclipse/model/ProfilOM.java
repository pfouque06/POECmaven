package org.eclipse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfilOM {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libelle;

	public ProfilOM() {
		super();
	}

	public ProfilOM(String code, String libelle) {
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
		return "\tProfilOM[" + id + "]  " + libelle + " (code=" + code + ")";
	}

}
