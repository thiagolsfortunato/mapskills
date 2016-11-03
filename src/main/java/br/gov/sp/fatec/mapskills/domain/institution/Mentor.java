/*
 * @(#)Mentor.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.user.Login;
import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.domain.user.User;

@Entity
@Table(name = "mentor")
@PrimaryKeyJoinColumn(name = "use_id")
public class Mentor extends User {

	private static final long serialVersionUID = 1L;

	public Mentor() { }
	
	public Mentor(final String name, final String email, final String password) {
		super(name, new Login(email, password), ProfileType.MENTOR);
	}	

}
