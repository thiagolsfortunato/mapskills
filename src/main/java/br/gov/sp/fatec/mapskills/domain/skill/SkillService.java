package br.gov.sp.fatec.mapskills.domain.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;


public class SkillService implements PersistenceService<Skill>{

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
