package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class SkillTest {
	
	@Autowired(required = true)
	@Qualifier("skillService")
	private SkillService service;
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@After
	public void downDataBase() {
		System.out.println("desce o banco");
	}
	
	@Test
	public void save() {
		final Skill skill = new Skill("Liderança", "Breve descrição da habilidade");
		service.save(skill);
		
		assertEquals("Liderança", service.findById(skill.getId()).getType());
		
	}

	@Test
	public void update() {
		final Skill skillSave = new Skill("Liderança", "Breve descrição da habilidade");
		service.save(skillSave);
		Skill skill = service.findById(1);
		skill.changeType("Trabalho em Equipe");
		service.update(skill);
		
		assertEquals("Trabalho em Equipe", service.findById(1).getType());
		
	}

}
