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

import br.gov.sp.fatec.mapskills.domain.question.Alternative;
import br.gov.sp.fatec.mapskills.domain.question.Multimedia;
import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.domain.question.QuestionService;
import br.gov.sp.fatec.mapskills.domain.question.Text;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class GameThemeTest {

	@Autowired
	private GameThemeService service;
	
	@Autowired(required = true)
	private QuestionService questionService;
	
	@Test
	public void saveTheme() {
		final GameTheme theme = new GameTheme("pizzaria, aplicado em 2016/2");
		service.save(theme);
		
		assertEquals("pizzaria, aplicado em 2016/2", service.findById(theme.id()).description());
		assertFalse(service.findById(theme.id()).isActive());
	}
	
	@Test
	public void findAllQustionsIsEnableByThemeId() {
		final GameTheme theme = new GameTheme("pizzaria, aplicado em 2016/2");
		service.save(theme);
		
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final List<Text> texts = buildMockTexts();
		final Question questionA = new Question("Questao001 Mock", alternatives, texts, SKILL_ID, THEME_ID);
		final Question questionB = new Question("Questao002 Mock", alternatives, texts, SKILL_ID, THEME_ID);
		final Question questionC = new Question("Questao003 Mock", alternatives, texts, SKILL_ID, THEME_ID);
		final List<Question> questions = new ArrayList<>();
		questions.add(questionA);
		questions.add(questionB);
		questions.add(questionC);
		questionService.create(questions);
		
		final int THEME = 1;
		final List<Question> questionsList = new ArrayList<>();
		questions.addAll(service.findAllQuestionsIsEnableByThemeId(THEME));
		
		assertEquals(3, questionsList.size());
	}
	
	@Test
	public void findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		themes.addAll(service.findAllThemes());
		
		assertEquals(1, themes.size());
	}
	
	private List<Alternative> builderMockAlternatives() {
		final List<Alternative> alternatives = new ArrayList<>();
		final Alternative a = new Alternative("AlternativaMockA", 8);
		final Alternative b = new Alternative("AlternativaMockB", 5);
		final Alternative c = new Alternative("AlternativaMockC", 6);
		final Alternative d = new Alternative("AlternativaMockD", 4);
		alternatives.add(a);
		alternatives.add(b);
		alternatives.add(c);
		alternatives.add(d);
		return alternatives;
	}
	
	private List<Text> buildMockTexts() {
		final List<Text> texts = new ArrayList<>();
		texts.add(new Text("TextoMock001", new Multimedia("http://site/img/001")));
		texts.add(new Text("TextoMock002", new Multimedia("http://site/img/002")));
		texts.add(new Text("TextoMock003", new Multimedia("http://site/img/003")));
		return texts;
	}
}
