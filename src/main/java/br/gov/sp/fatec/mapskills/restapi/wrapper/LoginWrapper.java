/*
 * @(#)LoginWrapper.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.LoginDeserializer;

@JsonDeserialize(using = LoginDeserializer.class)
public class LoginWrapper {
	
	private final String username;
	private final String password;
	
	public LoginWrapper(final String username, final String password) {
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
