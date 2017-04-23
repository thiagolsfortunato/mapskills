/*
 * @(#)ProfileType.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

/**
 * 
 * A classe {@link ProfileType} representa os tipos de perfis
 * que podem ser assumidos pelos usuarios da aplicacao.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
public enum ProfileType {
	
	UNRATED(0), ADMINISTRATOR(1), MENTOR(2), STUDENT(3);
	
	private final int id;
	
	private ProfileType(final int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isAdmin() {
		return this.equals(ADMINISTRATOR);
	}


}
