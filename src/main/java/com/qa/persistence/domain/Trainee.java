package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long traineeID;
	String firstName;
	String lastName;

	Long classroomID;

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

	public Long gettraineeID() {
		return this.traineeID;
	}

	public String settraineeID(Long id) {

		this.traineeID = id;

		return "ID Changed";
	}

	public String setClassroomID(Long id) {

		this.classroomID = id;

		return "ID changed";
	}

	public Long getClassroomID() {
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


	public String setTrainerID(Long id) {

		this.classroomID = id;

		return "ID Changed";
	}

}
