/*
 * @(#)MentorService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.gov.sp.fatec.mapskills.infrastructure.PersistenceService;


public class InstitutionService implements PersistenceService<Institution> {
	
	@Autowired(required = true)
	@Qualifier("mentorRepository")
	private InstitutionRepository repository;

	public void create(final Institution obj) {
		repository.save(obj);
	}

	public Institution findById(final Integer id) {
		return repository.findById(id);
	}

	
}