/*
 * @(#)GameThemeTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.test.unit.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class GameThemeTest extends MapSkillsTest {

	@Autowired
	private GameThemeService themeService;
	
	@Autowired
	private SceneService sceneService;
	
	@After
	public void cleanTables() {
		super.cleanTables(themeService);
		super.cleanTables(sceneService);
	}
	
	@Test
	public void saveTheme() {
		final GameTheme theme = new GameTheme("pizzaria, aplicado em 2016/2");
		themeService.save(theme);
		
		assertEquals("pizzaria, aplicado em 2016/2", themeService.findById(theme.getId()).getDescription());
		assertFalse(themeService.findById(theme.getId()).isActive());
	}
	
	
	@Test
	public void findAllThemes() {
		themeService.save(buildMockThemes());
		final List<GameTheme> themes = new ArrayList<>();
		themes.addAll(themeService.findAllThemes());
		
		assertEquals(4, themes.size());
	}
	
	private List<GameTheme> buildMockThemes() {
		final GameTheme themeA = new GameTheme("pizzaria, aplicado em 2016/2");
		final GameTheme themeB = new GameTheme("pizzaria, aplicado em 2016/2");
		final GameTheme themeC = new GameTheme("pizzaria, aplicado em 2016/2");
		final GameTheme themeD = new GameTheme("pizzaria, aplicado em 2016/2");
		final List<GameTheme> themes = new ArrayList<>(4);
		themes.add(themeA);
		themes.add(themeB);
		themes.add(themeC);
		themes.add(themeD);
		return themes;
	}
	
}
