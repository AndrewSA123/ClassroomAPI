package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.faces.bean.ApplicationScoped;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class ClassroomAlt implements IConnect {

	private JSONUtil util;
	HashMap<Long, Trainer> accounts = new HashMap<>();
	@Transactional(REQUIRED)
	public String createTrainer(String account) {
		Trainer acc = util.getObjectForJSON(account, Trainer.class);
		accounts.put(acc.getID(), acc);
		return "{\"message\": \"Account Successfully Added\"}";

	}

	public Trainer findTrainer(Long id) {
		return accounts.get(id);
	}

	public String getAllTrainer() {
		return accounts.values().toString();
	}

	@Transactional(REQUIRED)
	public String deleteTrainer(Long id) {
		Trainer accountInDb = findTrainer(id);
		if (accountInDb != null) {
			accounts.remove(id);
		}
		return "{\"message\": \"Account sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainer(String a, Long id) {
		Trainer NewAccount = util.getObjectForJSON(a, Trainer.class);
		accounts.put(id, NewAccount);
		return "{\"message\": \"Account sucessfully updated\"}";

	}

	@Override
	public String createTrainee(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainee findTrainee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTrainee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTrainee(String a, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
