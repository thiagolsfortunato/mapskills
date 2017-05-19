/*
 * @(#)StudentTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;
import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEventRepository;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
/**
 * 
 * A classe {@link StudentTest}
 *
 * @author Marcelo
 * @version 1.0 29/12/2016
 */

public class StudentTest extends MapSkillsTest {
	
	@Autowired
	private SceneService sceneService;
	
	@Autowired
	private AnswerEventRepository repo;
	
	@Autowired
	private SkillService skillService;
	
	@Before
	public void cleanTables() {
		super.cleanTables(sceneService, skillService);
	}
	
	@Test
	//Necessario configurar banco H2 para trabalhar com view
	public void getResultByStudent() {
		prepareAnswerContext();
		//final List<Object[]> resultSet = sceneService.getResultByStudentId(3);
	}
	
	@Test
	//Necessario configurar banco H2 para trabalhar com view
	public void testResultView() {
		prepareAnswerContext();
		//repo.findResultViewByStudentId(1);
	}
	
	private void prepareAnswerContext() {
		final long SCENEID = 1;
		final int SCENE_INDEX = 1;
		final long STUDENTID = 1;
		final int SKILLVALUE = 10;
		
		final Skill skillA = skillService.save(Skill.builder().type("liderança").description("liderança ...").build());
		final Skill skillB = skillService.save(Skill.builder().type("persuasão").description("persuasão ...").build());
		final Skill skillC = skillService.save(Skill.builder().type("visão de futuro").description("visão de futuro ...").build());
				
		for(int i = 0; i < 3; i++ ) {
			final AnswerEvent answer = new AnswerEvent(SCENE_INDEX + i, SCENEID + i, STUDENTID, skillA.getId(), SKILLVALUE + 1);
			sceneService.saveAnswer(answer);
		}
		for(int i = 3; i < 6; i++ ) {
			final AnswerEvent answer = new AnswerEvent(SCENE_INDEX + i, SCENEID + i, STUDENTID, skillB.getId(), SKILLVALUE + 2);
			sceneService.saveAnswer(answer);
		}
		for(int i = 6; i < 9; i++ ) {
			final AnswerEvent answer = new AnswerEvent(SCENE_INDEX + i, SCENEID + i, STUDENTID, skillC.getId(), SKILLVALUE + 3);
			sceneService.saveAnswer(answer);
		}

	}

}
