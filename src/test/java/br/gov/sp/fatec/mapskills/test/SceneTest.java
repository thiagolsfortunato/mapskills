/*
 * @(#)SceneTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class SceneTest extends MapSkillsTest {
	
	@Autowired
	private SceneService service;

	@After
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void save() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question(alternatives, SKILL_ID);
		final Scene scene = new Scene("", "", question, THEME_ID);
		service.save(scene);
	}
	
	@Test
	public void saveList() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question(alternatives, SKILL_ID);
		final Scene scene1 = new Scene("texto 1", "/scenes/img001.png", null, THEME_ID);
		final Scene scene2 = new Scene("questão", "/scenes/img002.png", question, THEME_ID);
		final Scene scene3 = new Scene("texto 1", "/scenes/img003.png", null, THEME_ID);
		final List<Scene> scenes = new ArrayList<>(3);
		scenes.add(scene1);
		scenes.add(scene2);
		scenes.add(scene3);
		service.save(scenes);
			
		assertEquals(3, service.findAllByGameThemeIdAndEnabled(THEME_ID).size());
	}
	
	@Test
	public void nextIndex() {
		final int index = service.nextIndex(1);
		
		assertEquals(1, index);
	}

	@Test
	public void update() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question(alternatives, SKILL_ID);
		final Scene sceneSave1 = new Scene("textoA", "/scenes/img004.png", null, THEME_ID);
		final Scene sceneSave2 = new Scene("textoB", "/scenes/img005.png", question, THEME_ID);
		service.save(sceneSave1);
		service.save(sceneSave2);
		
		final LinkedList<Scene> scenesResponse = new LinkedList<>(); 
		scenesResponse.addAll(service.findAllByGameThemeIdAndEnabled(THEME_ID));
		final Scene sceneUpdate = scenesResponse.getFirst();
		sceneUpdate.disable();
		service.save(sceneUpdate);
		
		final List<Scene> scenes = new ArrayList<>(); 
		scenes.addAll(service.findAllByGameThemeIdAndEnabled(THEME_ID));
		assertTrue(scenes.get(0).isEnabled());
	}

}
