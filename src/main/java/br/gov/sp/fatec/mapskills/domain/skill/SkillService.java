/*
 * @(#)SkillService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

public class SkillService implements RepositoryService<Skill>{

	@Autowired(required = true)
	@Qualifier("skillRepository")
	private SkillRepository repository;

	public void create(final Skill skill) {
		repository.save(skill);
	}
	
	public void update(final Skill skill) {
		repository.save(skill);
	}

	public Skill findById(final Integer id) {
		return repository.findById(id);
	}
	

}
