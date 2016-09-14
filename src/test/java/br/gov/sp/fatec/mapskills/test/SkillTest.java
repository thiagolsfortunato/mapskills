package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.mapskills.skill.Skill;
import br.gov.sp.fatec.mapskills.skill.SkillRepository;

public class SkillTest implements ApplicationTest{
	
	@Autowired
	SkillRepository repository;

	@Test
	@Transactional
	public void save() {
		Skill skill = new Skill("Liderança");
		repository.save(skill);
		
		assertEquals("Liderança", repository.findById(skill.id()).description());
		
	}

	@Test
	@Transactional
	public void update() {
		Skill skill = repository.findById(1);
		skill.changeDescription("Trabalho em Equipe");
		repository.save(skill);
		
		assertEquals("Trabalho em Equipe", repository.findById(1).description());
		
	}

}
