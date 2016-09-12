package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.gov.sp.fatec.mapskills.domain.Skill;
import br.gov.sp.fatec.mapskills.repository.SkillRepository;

public class SkillTest implements ApplicationTest{
	
	SkillRepository repository = new SkillRepository();

	@Test
	public void save() {
		Skill skill = new Skill("Liderança");
		repository.save(skill);
		
		assertEquals("Liderança", repository.findById(skill.id()).description());
		repository.close();
		
	}

	@Test
	public void update() {
		Skill skill = repository.findById(1);
		skill.changeDescription("Trabalho em Equipe");
		repository.update(skill);
		
		assertEquals("Trabalho em Equipe", repository.findById(1).description());
		repository.close();
		
	}

}
