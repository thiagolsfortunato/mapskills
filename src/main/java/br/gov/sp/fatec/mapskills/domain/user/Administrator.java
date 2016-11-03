/*
 * @(#)Administrator.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
@PrimaryKeyJoinColumn(name = "use_id")
public class Administrator extends User {

	private static final long serialVersionUID = 1L;
	
	public Administrator(final String name, final String email, final String password) {
		super(name, new Login(email, password), ProfileType.ADMINISTRATOR);
	}

}
