package br.gov.sp.fatec.mapskills.domain.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;

@Service
public class SkillService implements PersistenceService<Skill>{

	@Autowired(required = true)
	@Qualifier("skillRepository")
	SkillRepository repository;

	@Override
	public void create(final Skill skill) {
		repository.save(skill);
	}

	@Override
	public Skill findById(final Integer id) {
		return repository.findById(id);
	}

}
