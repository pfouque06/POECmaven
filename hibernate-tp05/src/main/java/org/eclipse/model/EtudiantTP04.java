package org.eclipse.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "ETU")
public class EtudiantTP04 extends PersonneTP04 {

	private String niveau;

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	
}
