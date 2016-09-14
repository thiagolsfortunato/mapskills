package br.gov.sp.fatec.mapskills.skill;

import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Integer> {
	
	public Skill findById(final Integer id);

}
