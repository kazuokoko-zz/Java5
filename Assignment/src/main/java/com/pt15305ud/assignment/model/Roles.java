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

@Entity
@Data
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "rolename", nullable = false, length = 15)
	private String name;

	@ToString.Exclude
	@OneToMany(mappedBy = "roles",fetch = FetchType.EAGER)
	List<UserRole> userRoles;
}
