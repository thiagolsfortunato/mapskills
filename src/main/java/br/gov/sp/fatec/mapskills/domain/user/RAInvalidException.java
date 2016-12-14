/*
 * @(#)RAInvalidException.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * A classe RAInvalidException lança uma exception caso encontre uma mal formação no RA
 * @author Marcelo Inácio
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RAInvalidException extends MapSkillsException {

	private static final long serialVersionUID = 1L;	
	private final String ra;
	
	public RAInvalidException(final String ra) {
		super();
		this.ra = ra;
	}
	
	public String ra() {
		return ra;
	}

}
