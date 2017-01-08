/*
 * @(#)SaveImageException.java 1.0 06/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * A classe <code>SaveImageException</code. gera uma exceção quando é
 * encontrada um problema ao salvar a imagem na aplicação
 * @author Marcelo
 *
 */
public class SaveImageException extends MapSkillsException {

	private static final long serialVersionUID = 1L;
	
	private final String filename;
	
	public SaveImageException(final String filename) {
		super();
		this.filename = filename;
	}
	
	public String getFilename() {
		return filename;
	}

}
