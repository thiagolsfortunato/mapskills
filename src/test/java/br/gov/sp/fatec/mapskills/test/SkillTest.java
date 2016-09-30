package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringRootConfig;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRootConfig.class, loader = AnnotationConfigContextLoader.class)
public class SkillTest implements ApplicationTest{
	
	@Autowired
	SkillService service;

	@Test
	@Override
	public void save() {
		final Skill skill = new Skill("Liderança");
		service.create(skill);
		
		assertEquals("Liderança", service.findById(skill.id()).description());
		
	}

	@Test
	@Override
	public void update() {
		Skill skill = service.findById(1);
		skill.changeDescription("Trabalho em Equipe");
		service.create(skill);
		
		assertEquals("Trabalho em Equipe", service.findById(1).description());
		
	}

}
