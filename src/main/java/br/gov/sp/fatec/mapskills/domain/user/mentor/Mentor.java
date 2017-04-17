/*
 * @(#)Mentor.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user.mentor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.user.Login;
import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MENTOR")
@PrimaryKeyJoinColumn(name = "use_id")
public class Mentor extends User {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ins_id")
	private long institutionId;
	
	@Column(name = "ins_code")
	private String institutionCode;

	public Mentor() {
		// CONSTRUCTOR DEFAULT
	}
	
	@Builder
	public Mentor(final long id, final String name, final long institutionId, final String institutionCode,
			final String username, final String password) {
		
		super(id, name, new Login(username, password), ProfileType.MENTOR);
		this.institutionCode = institutionCode;
		this.institutionId = institutionId;
	}
	
	public Mentor(final String name, final String institutionCode, final String username, final String password) {
		super(name, new Login(username, password), ProfileType.MENTOR);
		this.institutionCode = institutionCode;
	}
		
	public void setName(final String name) {
		super.setName(name);
	}

}
