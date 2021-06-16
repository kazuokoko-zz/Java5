package com.pt15305ud.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private Long accountId;

	@Column(name = "role_id", nullable = false)
	private int roleId;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	Roles roles;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "accountId", insertable = false, updatable = false)
	Account account;
//	
//	@Override
//	public String toString()
}
