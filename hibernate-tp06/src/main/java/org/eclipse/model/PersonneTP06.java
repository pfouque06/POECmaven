package org.eclipse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class PersonneTP06 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // for TABLE_PER_CLASS inheritance ORM model
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // for SINGLE_TABLES inheritance ORM model
	private int num;
	private FullNameTP06 fullName;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public FullNameTP06 getFullName() {
		return fullName;
	}

	public void setFullName(FullNameTP06 fullName) {
		this.fullName = fullName;
	}

}
