package org.eclipse.models;

import java.util.Date;
import java.util.List;

import org.eclipse.classes.DateSerializer;

public class Employe {

	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private List<String> roles;

	public Employe(int id, String firstName, String lastName, Date birthDate, List<String> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "employe [" + id + "] firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", roles=" + roles + "]";
	}

	
}
