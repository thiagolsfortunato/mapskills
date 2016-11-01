/*
 * @(#)MentorService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.user.PersistenceService;


public class MentorService implements PersistenceService<Mentor> {
	
	@Autowired(required = true)
	@Qualifier("mentorRepository")
	private MentorRepository repository;

	public void create(final Mentor obj) {
		repository.save(obj);
	}

	public Mentor findById(final Integer id) {
		return repository.findById(id);
	}

	
}