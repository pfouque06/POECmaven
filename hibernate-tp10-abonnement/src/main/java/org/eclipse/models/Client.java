package org.eclipse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for TABLE_PER_CLASS inheritance ORM model
	private Integer idClient;
	private FullName nom;
	private String email;
	private String tel;
	private String ville;
	
	public Client() {
		super();
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public FullName getNom() {
		return nom;
	}

	public void setNom(FullName nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "\tClient [" + idClient + "] nom=" + nom + ", email=" + email + ", tel=" + tel + ", ville="
				+ ville;
	}
	
	
	
}
