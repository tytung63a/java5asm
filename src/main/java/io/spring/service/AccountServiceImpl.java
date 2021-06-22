package io.spring.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.spring.entities.Account;
import io.spring.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public <S extends Account> S save(S entity) {
		return accountRepository.save(entity);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}

	@Override
	public boolean checkLogin(@Valid Account account) {
		return true;
	}

	@Override
	public boolean existsById(String id) {
		return accountRepository.existsById(id);
	}
	
	@Override
	public Page<Account> findAll(Integer page, Integer limit, String field) {
		if (field.equals("")) {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.ASC, "username"));
			return accountRepository.findAll(pageable);
		}
		else {
			Pageable pageable = PageRequest.of(page, limit , Sort.by(Direction.DESC, field));
			return accountRepository.findAll(pageable);
		}
	}
	
}
