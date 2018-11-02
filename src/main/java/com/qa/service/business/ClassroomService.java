package com.qa.service.business;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.IConnect;

public class ClassroomService implements IClassroomService {

	@Inject
	private IConnect repo;

	@Override
	public Account getAccount(Long accountNum) {
		return repo.findAccount(accountNum);
	}

	@Override
	public String createAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String getAllAccounts() throws JsonProcessingException {
		return repo.getAllAccounts();
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(account, id);
	}
}
