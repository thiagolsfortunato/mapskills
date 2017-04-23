/*
 * @(#)ReadFileException.java 1.0 21/01/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * 
 * A classe {@link ReadFileException} e lancada
 * quando um problema ao ler um arquivo e encontrado.
 *
 * @author Marcelo
 * @version 1.0 21/01/2017
 */
public class ReadFileException extends MapSkillsException {
	
	private static final long serialVersionUID = 1L;
	
	public ReadFileException(final String message) {
		super(message);
	}

}
