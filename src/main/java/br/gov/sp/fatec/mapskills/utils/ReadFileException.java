/*
 * @(#)ReadFileException.java 1.0 21/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;

public class ReadFileException extends MapSkillsException {
	
	private static final long serialVersionUID = 1L;
	
	public ReadFileException(final String message) {
		super(message);
	}

}
