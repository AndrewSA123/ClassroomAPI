package com.qa.service.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;

public interface IClassroomService {

	Trainer getTrainer(Long accountNum);

	Trainee getTrainee(Long accountNum);

	String createTrainer(String account);

	String createTrainee(String account);

	String getAllTrainers() throws JsonProcessingException;

	String deleteTrainer(Long id);

	String deleteTrainee(Long id);

	String updateTrainer(Long id, String account);

	String updateTrainee(Long id, String account);

}