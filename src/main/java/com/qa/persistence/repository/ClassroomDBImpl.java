package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class ClassroomDBImpl implements IConnect {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;


	@Override
	@Transactional(REQUIRED)
	public String createTrainer(String trainer) {
		Trainer acc = util.getObjectForJSON(trainer, Trainer.class);
		manager.persist(acc);
		return "{\"message\": \"Trainer Successfully Added\"}";

	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee acc = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(acc);
		return "{\"message\": \"Trainee Successfully Added\"}";

	}

	@Override
	public Trainer findTrainer(Long id) {
		return manager.find(Trainer.class, id);
	}

	@Override
	public Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}


	@Override
	public String getAllTrainer() {
		Query q = manager.createQuery("Select a FROM Trainer a");
		Collection<Trainer> accounts = (Collection<Trainer>) q.getResultList();
		return util.getJSONForObject(accounts);
	}


	@Override
	@Transactional(REQUIRED)
	public String deleteTrainer(Long id) {
		Trainer accountInDb = findTrainer(id);
		if (accountInDb != null) {
			manager.remove(accountInDb);
		}
		return "{\"message\": \"Trainer sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee accountInDb = findTrainee(id);
		if (accountInDb != null) {
			manager.remove(accountInDb);
		}
		return "{\"message\": \"Trainee sucessfully deleted\"}";
	}


	@Override
	@Transactional(REQUIRED)
	public String updateTrainer(String a, Long id) {
		Trainer newAccount = util.getObjectForJSON(a, Trainer.class);
		Trainer old = manager.find(Trainer.class, id);

		old.setFirstName(newAccount.getFirstName());
		old.setLastName(newAccount.getLastName());

		return "{\"message\": \"Trainer sucessfully updated\"}";


	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(String a, Long id) {
		Trainee newAccount = util.getObjectForJSON(a, Trainee.class);
		Trainee old = manager.find(Trainee.class, id);

		old.setFirstName(newAccount.getFirstName());
		old.setLastName(newAccount.getLastName());

		return "{\"message\": \"Trainee sucessfully updated\"}";

	}

}
