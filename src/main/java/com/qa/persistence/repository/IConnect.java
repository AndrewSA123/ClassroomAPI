package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;

public interface IConnect {

	String createTrainer(String account);

	Trainer findTrainer(Long id);

	String getAllTrainer();

	String deleteTrainer(Long id);

	String updateTrainer(String a, Long id);

	String createTrainee(String account);

	Trainee findTrainee(Long id);

	String deleteTrainee(Long id);

	String updateTrainee(String a, Long id);

}