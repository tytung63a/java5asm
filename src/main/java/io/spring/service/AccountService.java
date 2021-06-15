package io.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.entities.Account;
import io.spring.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account save(Account entity) { 		
		return accountRepository.save(entity);
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}
	
	
}
