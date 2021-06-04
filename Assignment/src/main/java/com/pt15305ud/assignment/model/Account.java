package com.pt15305ud.assignment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false, unique = true, length = 50)
	private String uesrName;

	@Column(name = "password", nullable = false, length = 50)
	private String passWord;

	@Column(name = "phone", unique = true, length = 15)
	private String phone;

	@Column(name = "email", unique = true, length = 50)
	private String email;

	@Column(name = "actived", nullable = false)
	private boolean actived;
	

	@OneToMany(mappedBy = "account")
	private List<Order> orders;
}
