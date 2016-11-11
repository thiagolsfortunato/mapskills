/*
 * @(#)RAInvalidException.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

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
