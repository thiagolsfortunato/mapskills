/*
 * @(#)User.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_id")
	private Integer id;
	
	@Column(name = "use_name")
	private String name;
	
	@Column(name = "use_email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "use_password", nullable = false)
	private String password;
	
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "pro_id")
	private ProfileType profile;
/*	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "log_id")
	private Login login;
*/	
	public User() {}
	
	public User(final String name, final String email, final String password, final ProfileType profile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}
	
	public void profile(final ProfileType profile) {
		this.profile = profile;
	}
	
	public Integer id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public String email() {
		return email;
	}
	
	public String password() {
		return password;
	}
	
	public void changeName(final String newName) {
		name = newName;
	}

}
