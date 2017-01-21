/*
 * @(#)SkillService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.skill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class SkillService implements RepositoryService {

	@Autowired(required = true)
	@Qualifier("skillRepository")
	private SkillRepository repository;
	
	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	public void save(final Skill skill) {
		repository.save(skill);
	}
	
	public void update(final Skill skill) {
		repository.save(skill);
	}
	
	public Collection<Skill> findAll() {
		final List<Skill> skills = new ArrayList<>();
		for(final Skill skill : repository.findAll()) {
			skills.add(skill);
		}
		return skills;
	}

	public Skill findById(final long id) {
		return repository.findById(id);
	}

}
