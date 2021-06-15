package io.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}