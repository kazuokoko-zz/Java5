package com.pt15305ud.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pt15305ud.assignment.interfaces.AccountRepository;
import com.pt15305ud.assignment.interfaces.RolesRepository;
import com.pt15305ud.assignment.interfaces.UserRoleRepository;
import com.pt15305ud.assignment.model.Account;
import com.pt15305ud.assignment.model.Roles;
import com.pt15305ud.assignment.model.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountRepository _accountRepo;

	@Autowired
	private UserRoleRepository _userRoleRepo;

	@Autowired
	private RolesRepository _rolesRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Account> lst = this._accountRepo.findByUserName(userName);
		Account account;

		if (lst.size() > 0) {
			account = lst.get(0);
		} else {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}

		System.out.println("Found User: " + account);

		// [ROLE_USER, ROLE_ADMIN,..]
		List<String> roleNames = new ArrayList<String>();
//		List<Account> lst =_accountRepo.findByUserName(userName);
//		if( lst.size()>0) {
//		Account a = lst.get(0);
		for (UserRole ur : this._userRoleRepo.findByAccountId(account.getId())) {
			Optional<Roles> opt = this._rolesRepo.findById(ur.getRoleId());
			if (opt.isPresent())
				roleNames.add(opt.get().getName());
		}

//		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleNames.size() > 0) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = (UserDetails) new User(account.getUserName(), //
				account.getEncrytedPassword(), grantList);

		return userDetails;
	}
}
