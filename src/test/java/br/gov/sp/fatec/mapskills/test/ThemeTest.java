package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ThemeTest implements ApplicationTest {

	@Autowired
	private GameThemeService service;
	
	@Test
	public void saveTheme() {
		final GameTheme theme = new GameTheme("pizzaria, aplicado em 2016/2");
		service.save(theme);
		
		assertEquals("pizzaria, aplicado em 2016/2", service.findById(theme.id()).description());
		assertFalse(service.findById(theme.id()).isActive());
	}
	
	@Test
	public void findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		themes.addAll(service.findAllThemes());
		
		assertEquals(0, themes.size());
	}
}
