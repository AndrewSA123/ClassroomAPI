package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.repository.IConnect;

public class ClassroomService implements IClassroomService {

	@Inject
	private IConnect repo;

	@Override
	public Trainer getTrainer(Long accountNum) {
		return repo.findTrainer(accountNum);
	}

	public Trainee getTrainee(Long accountNum) {
		return repo.findTrainee(accountNum);
	}

	@Override
	public String createTrainer(String account) {
		return repo.createTrainer(account);
	}

	@Override
	public String createTrainee(String account) {
		return repo.createTrainee(account);
	}

	@Override
	public String getAllTrainers() {
		return repo.getAllTrainer();
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	@Override
	public String deleteTrainer(Long id) {
		return repo.deleteTrainer(id);
	}

	@Override
	public String updateTrainer(Long id, String account) {
		return repo.updateTrainer(account, id);
	}

	@Override
	public String updateTrainee(Long id, String account) {
		return repo.updateTrainee(account, id);
	}
}
