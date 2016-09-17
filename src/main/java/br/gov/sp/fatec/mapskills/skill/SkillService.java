package br.gov.sp.fatec.mapskills.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

	@Autowired(required = true)
	@Qualifier("skillRepository")
	SkillRepository repository;

	public void save(final Skill skill) {
		repository.save(skill);
	}

	public Skill findById(final Integer id) {
		return repository.findById(id);
	}

}
