/*
 * @(#)SaveImageException.java 1.0 06/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * A classe <code>SaveImageException</code> lançada quando é
 * encontrada um problema ao salvar a imagem no servidor aplicação 
 * @author Marcelo
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SaveImageException extends MapSkillsException {

	private static final long serialVersionUID = 1L;
	
	private final String filename;
	
	public SaveImageException(final String filename, final Exception e) {
		super("Problema ao salvar ".concat(filename));
		this.filename = filename;
	}
	
	public String getFilename() {
		return filename;
	}

}
