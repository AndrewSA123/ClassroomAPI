package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long classroomID;
	@Column(length = 45)
	String firstName;
	@Column(length = 45)
	String lastName;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "traineeID")
	List<String> trainees = new ArrayList<String>();

	public Trainer() {

	}

	public Trainer(String fName, String lName) {

		firstName = fName;
		lastName = lName;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"firstName\": " + "\"" + this.firstName + "\"" + "," + "\n\"lastName\": " + "\"" + this.lastName
				+ "\"" + "}";
	}

	public Long getID() {
		return this.classroomID;
	}


	public String setFirstName(String name) {

		firstName = name;

		return "First Name Changed";
	}

	public String setLastName(String name) {

		lastName = name;

		return "Last Name Changed";
	}


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public String getName() {

		return firstName + " " + lastName;
	}

}
