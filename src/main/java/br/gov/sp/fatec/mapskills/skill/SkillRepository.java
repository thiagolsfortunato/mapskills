package br.gov.sp.fatec.mapskills.skill;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
	
	public Skill findById(final Integer id);

}
