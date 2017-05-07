/*
 * @(#)SceneTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeRepository;
/**
 * 
 * A classe {@link SceneTest} contem os testes
 * do aggregate <code>GameTheme</code>.
 *
 * @author Marcelo
 * @version 1.0 29/12/2016
 */
public class SceneTest extends MapSkillsTest {
	
	@Autowired
	private SceneService service;
	@Autowired
	private GameThemeRepository themeRepo;

	@Before
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void save() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = Question.builder().alternatives(alternatives).skillId(SKILL_ID).build();
		final Scene scene = Scene.builder().text("intro").urlBackground("url:site").question(question).gameThemeId(THEME_ID).build();
		service.save(scene);
	}
	
	@Test
	public void saveList() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = Question.builder().alternatives(alternatives).skillId(SKILL_ID).build();
		final Scene scene1 = Scene.builder().text("texto 1").urlBackground("/scenes/img001.png").question(null).gameThemeId(THEME_ID).build();
		final Scene scene2 = Scene.builder().text("questão").urlBackground("/scenes/img002.png").question(question).gameThemeId(THEME_ID).build();
		final Scene scene3 = Scene.builder().text("texto 1").urlBackground("/scenes/img003.png").question(null).gameThemeId(THEME_ID).build();
		final List<Scene> scenes = new ArrayList<>(3);
		scenes.add(scene1);
		scenes.add(scene2);
		scenes.add(scene3);
		service.save(scenes);
			
		assertEquals(3, service.findAllByGameThemeId(THEME_ID).size());
	}
	
	@Test
	public void nextIndex() {
		
		final GameTheme themeA = themeRepo.save(GameTheme.builder().name("descrição tema 001").build());
		final GameTheme themeB = themeRepo.save(GameTheme.builder().name("descrição tema 002").build());
		
		final int index = service.nextIndex(themeA.getId());
		assertEquals(0, index);
		
		service.save(Scene.builder().text("intro").urlBackground("url:site").question(null).gameThemeId(themeB.getId()).build());
		
		final int nextIndex = service.nextIndex(themeB.getId());
		
		assertEquals(1, nextIndex);
	}

	@Test
	public void update() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = Question.builder().alternatives(alternatives).skillId(SKILL_ID).build();
		final Scene sceneSave2 = Scene.builder().text("textoB").urlBackground("/scenes/img005.png").question(question).gameThemeId(THEME_ID).build();
		service.save(sceneSave2);
		
		final Scene sceneUpdate = Scene.builder().text("TextoA").urlBackground("/images/img001.png").question(null).gameThemeId(THEME_ID).build();
		sceneUpdate.setId(sceneSave2.getId());
		service.save(sceneUpdate);

	}

}
