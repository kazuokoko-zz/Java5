package com.pt15305ud.assignment.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pt15305ud.assignment.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByUserName(String userName);

	@Query("select a from Account a where a.userName like %:userName%")
	Page<Account> findByUserNameLike(Pageable page, @Param("userName") String userName);
}
