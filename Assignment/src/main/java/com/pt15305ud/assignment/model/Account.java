package com.pt15305ud.assignment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, unique = true, nullable = false)
	private String userName;
//
//	@Column(name = "password", nullable = false, length = 50)
//	private String passWord;

	@Column(length = 128, nullable = false)
	private String encrytedPassword;

	@Column(length = 15)
	private String phone;

	@Column(length = 50)
	private String email;

	@Column(nullable = false)
	private boolean actived;
//
//	@OneToMany(mappedBy = "account")
//	List<Order> orders;

	@ToString.Exclude
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<UserRole> userRoles;
}
