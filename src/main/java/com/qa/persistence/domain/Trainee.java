package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long traineeID;
	@Column(length = 45)
	String firstName;
	@Column(length = 45)
	String lastName;

	public Trainee() {

	}

	public Trainee(String fName, String lName) {

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
		return this.traineeID;
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
