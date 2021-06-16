package com.pt15305ud.assignment.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pt15305ud.assignment.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	@Query("select q from UserRole q where q.accountId =:accountId")
	List<UserRole> findByAccountId(@Param("accountId") Long accountId);

}
