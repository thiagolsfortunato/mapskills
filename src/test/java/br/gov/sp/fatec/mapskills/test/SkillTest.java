package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class SkillTest implements ApplicationTest{
	
	@Autowired
	@Qualifier("skillService")
	private SkillService service;

	@Test
	public void save() {
		final Skill skill = new Skill("Liderança", "Breve descrição da habilidade");
		service.create(skill);
		
		assertEquals("Liderança", service.findById(skill.id()).getType());
		
	}

	@Test
	public void update() {
		Skill skill = service.findById(1);
		skill.changeType("Trabalho em Equipe");
		service.update(skill);
		
		assertEquals("Trabalho em Equipe", service.findById(1).getType());
		
	}

}
