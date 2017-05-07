/*
 * @(#)SkillTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
/**
 * 
 * A classe {@link SkillTest} contem os teste
 * de unidade para a classe <code>Skill</code>.
 *
 * @author Marcelo
 * @version 1.0 29/12/2016
 */

public class SkillTest extends MapSkillsTest {
	
	@Autowired
	private SkillService service;
	
	@Before
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void save() {
		final Skill skill = Skill.builder().type("Liderança").description("Breve descrição da habilidade").build();
		service.save(skill);
		
		assertEquals("Liderança", service.findById(skill.getId()).getType());
		
	}
	
	@Test
	public void testClean() {
		final Collection<Skill> skillList = service.findAll();
		assertTrue(skillList.isEmpty());
		
	}

	@Test
	public void update() {
		final Skill skillSave = Skill.builder().type("Liderança").description("Breve descrição da habilidade").build();
		service.save(skillSave);
		
		final Skill skillUpdate = Skill.builder().type("força").description("Breve descrição da habilidade").build();
		skillUpdate.setId(skillSave.getId());
		service.update(skillUpdate);
		
		assertEquals("força", service.findById(skillSave.getId()).getType());
		
	}

}
