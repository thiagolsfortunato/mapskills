/*
 * @(#)Login.java 1.0 02/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * A classe <code>Login</code> representa as credenciais de acesso a aplcacao.
 * 
 * @author Marcelo
 *
 */
@Embeddable
public class Login {
	
	@Column(name = "use_username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "use_password", nullable = false)
	private String password;
	
	public Login() {}
	
	public Login(final String username, final String password) {
		this.username = username;
		this.password = password;
	}
	
	public String username() {
		return username;
	}
	
	public String password() {
		return password;
	}

}
