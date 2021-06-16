package com.pt15305ud.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.pt15305ud.assignment.interfaces.AccountRepository;
import com.pt15305ud.assignment.model.Account;

@Component
public class AccountService {

	@Autowired
	AccountRepository _accountRepo;

	public Page<Account> getPage(Pageable page) {
		return _accountRepo.findAll(page);
	}

	public Account findByUserName(String userName) {
		List<Account> lst = _accountRepo.findByUserName(userName);
		if (lst.size() > 0) {
			return lst.get(0);
		} else {
			return null;
		}

	}

	public Account getById(Long id) {
		return _accountRepo.getById(id);
	}
}
