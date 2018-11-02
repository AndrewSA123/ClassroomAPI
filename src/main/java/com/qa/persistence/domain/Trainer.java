package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomID;
	@Column(length = 45)
	private String firstName;
	@Column(length = 45)
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trainerID")
	private List<Trainee> trainees;;

	public Trainer() {

	}

	public Trainer(String fName, String lName, Trainee trainee) {

		firstName = fName;
		lastName = lName;
		this.trainees = (List<Trainee>) trainee;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"firstName\": " + "\"" + this.firstName + "\"" + "," + "\n\"lastName\": " + "\"" + this.lastName
				+ "\"" + "}";
	}

	public Long getClassroomID() {
		return this.classroomID;
	}

	public String setClassroomID(Long classroomID) {
		this.classroomID = classroomID;

		return "ID updated";
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

	public Trainee getTrainee() {
		return (Trainee) trainees;
	}

	public String setTrainee(Trainee trainee) {
		this.trainees = (List<Trainee>) trainee;

		return "Trainee added";
	}

}
