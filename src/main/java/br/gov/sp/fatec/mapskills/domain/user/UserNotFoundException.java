/*
 * @(#)UserNotFoundException.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Exception lançada quando falha ao tentar uma autenticação por um usuário
 * @author Marcelo
 *
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends MapSkillsException {

	private static final long serialVersionUID = 1L;
	
	private final String username;
	
	public UserNotFoundException(final String username) {
		super();
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

}
