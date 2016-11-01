/*
 * @(#)Mentor.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.domain.user.User;

@Entity
@Table(name = "mentor")
@PrimaryKeyJoinColumn(name = "use_id")
public class Mentor extends User {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ins_id")
	private Institution institution;
/*	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "log_id")
	private Login login;
*/	
	public Mentor() { }
	
	public Mentor(final String name, final String email, final String password, final Institution institution) {
		super(name, email, password, ProfileType.MENTOR);
		this.institution = institution;
	}
	
	public void changeInstitution(final Institution newInstitution) {
		this.institution.changeCompany(newInstitution.company());
		this.institution.changeCnpj(newInstitution.cnpj());
		this.institution.changeCity(newInstitution.city());
	}
	

}
