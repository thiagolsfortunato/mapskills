package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.skill.Skill;
import br.gov.sp.fatec.mapskills.skill.SkillRepository;
import br.gov.sp.fatec.mapskills.spring.SpringRootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRootConfig.class, loader = AnnotationConfigContextLoader.class)
public class SkillTest implements ApplicationTest{
	
	@Autowired
	SkillRepository repository;

	@Test
	public void save() {
		Skill skill = new Skill("Liderança");
		repository.save(skill);
		
		assertEquals("Liderança", repository.findById(skill.id()).description());
		
	}

	@Test
	public void update() {
		Skill skill = repository.findById(1);
		skill.changeDescription("Trabalho em Equipe");
		repository.save(skill);
		
		assertEquals("Trabalho em Equipe", repository.findById(1).description());
		
	}

}
