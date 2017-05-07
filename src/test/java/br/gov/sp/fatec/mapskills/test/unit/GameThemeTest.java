/*
 * @(#)GameThemeTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
/**
 * 
 * A classe {@link GameThemeTest} realiza
 * os testes de unidade para o objeto de dominio
 * <code>GameTheme</code>.
 *
 * @author Marcelo
 * @version 1.0 29/12/2016
 */
public class GameThemeTest extends MapSkillsTest {

	@Autowired
	private GameThemeService themeService;
	
	@Autowired
	private SceneService sceneService;
	
	@After
	public void cleanTables() {
		super.cleanTables(themeService, sceneService);
	}
	
	@Test
	public void saveTheme() {
		final GameTheme theme = GameTheme.builder().name("pizzaria aplicado em 2016/2").build();
		themeService.save(theme);
		
		assertEquals("pizzaria aplicado em 2016/2", themeService.findById(theme.getId()).getName());
		assertFalse(themeService.findById(theme.getId()).isActive());
	}
	
	
	@Test
	public void findAllThemes() {
		super.cleanTables(themeService, sceneService);
		themeService.save(buildMockThemes());
		final List<GameTheme> themes = new ArrayList<>();
		themes.addAll(themeService.findAllThemes());
		
		assertEquals(4, themes.size());
	}
	
	private List<GameTheme> buildMockThemes() {
		final List<GameTheme> themes = new ArrayList<>(4);
		themes.add(GameTheme.builder().name("pizzaria, aplicado em 2016/2").build());
		themes.add(GameTheme.builder().name("pizzaria, aplicado em 2016/2").build());
		themes.add(GameTheme.builder().name("pizzaria, aplicado em 2016/2").build());
		themes.add(GameTheme.builder().name("pizzaria, aplicado em 2016/2").build());
		return themes;
	}
	
}
