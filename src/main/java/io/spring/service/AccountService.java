package io.spring.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import io.spring.entities.Account;

public interface AccountService {

	void deleteById(String id);

	Optional<Account> findById(String id);

	List<Account> findAll();

	<S extends Account> S save(S entity);

	boolean checkLogin(@Valid Account account);

	boolean existsById(String id);

	Page<Account> findAll(Integer page, Integer limit, String field);
	
}
