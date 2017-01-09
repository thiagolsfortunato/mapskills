/*
 * @(#)MapSkillsException.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.application;
/**
 * Exception genérica de dominio
 * @author Marcelo
 *
 */
public class MapSkillsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MapSkillsException(final String message) {
		super(message);
	}
	
	public MapSkillsException() {
		super();
	}

}
