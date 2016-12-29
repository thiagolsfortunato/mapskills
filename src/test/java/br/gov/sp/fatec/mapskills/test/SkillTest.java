/*
 * @(#)SkillTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

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
public class SkillTest extends MapSkillsTest {
	
	@Autowired(required = true)
	@Qualifier("skillService")
	private SkillService service;
	
	@After
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void save() {
		final Skill skill = new Skill("Liderança", "Breve descrição da habilidade");
		service.save(skill);
		
		assertEquals("Liderança", service.findById(skill.getId()).getType());
		
	}
	
	@Test
	public void testClean() {
		final Collection<Skill> skillList = service.findAll();
		assertTrue(skillList.isEmpty());
		
	}

	//@Test
	public void update() {
		final Skill skillSave = new Skill("Liderança", "Breve descrição da habilidade");
		service.save(skillSave);
		Skill skill = service.findById(1);
		skill.changeType("Trabalho em Equipe");
		service.update(skill);
		
		assertEquals("Trabalho em Equipe", service.findById(1).getType());
		
	}

}
