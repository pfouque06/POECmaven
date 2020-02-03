package org.eclipse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TYPE_PERSONNE")
//@DiscriminatorValue(value = "PERS")
public class PersonneTP04 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // for TABLE_PER_CLASS inheritance ORM model
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // for SINGLE_TABLES inheritance ORM model
	private int num;
	private String nom;
	private String prenom;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

}
