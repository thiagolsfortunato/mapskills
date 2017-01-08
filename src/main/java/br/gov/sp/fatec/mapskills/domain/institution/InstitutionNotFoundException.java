/*
 * @(#)InstitutionNotFoundException.java 1.0 07/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * A classe <code>InstitutionNotFoundException</code> é lançada quando
 * nenhuma instituição é encontrada na base de dados da aplicação.
 * @author Marcelo
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstitutionNotFoundException extends MapSkillsException {

	private static final long serialVersionUID = 1L;
	private final long institutionId;
	
	public InstitutionNotFoundException(final long institutionId) {
		super();
		this.institutionId = institutionId;
	}
	
	public long getInstitutionId() {
		return institutionId;
	}

}
