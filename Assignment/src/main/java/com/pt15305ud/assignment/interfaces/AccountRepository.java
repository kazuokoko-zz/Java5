package com.pt15305ud.assignment.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt15305ud.assignment.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByUserName(String userName);

}
