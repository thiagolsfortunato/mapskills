package br.gov.sp.fatec.mapskills.test;

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

import br.gov.sp.fatec.mapskills.domain.question.Alternative;
import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.domain.question.QuestionService;
import br.gov.sp.fatec.mapskills.domain.question.Text;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class QuestionTest extends MapSkillsTest {
	
	@Autowired
	private QuestionService service;

	@After
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void save() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final List<Alternative> alternatives = builderMockAlternatives();
		final List<Text> texts = buildMockTexts();
		final Question question = new Question("Questao003 Mock", alternatives, texts, SKILL_ID, THEME_ID);
		service.create(question);
		
		assertEquals("Questao003 Mock", service.findById(question.getId()).getDescription());
	}
	
	@Test
	public void saveList() {
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
		service.create(questionA, questionB, questionC);
			
		assertEquals(3, service.questionList().size());
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
		final List<Text> texts = buildMockTexts();
		final Question questionA = new Question("Questao001 Mock", alternatives, texts, SKILL_ID, THEME_ID);
		service.create(questionA);
		
		final Question question = service.findById(questionA.getId());
		question.changeDescription("Questao001 Mock");
		question.disable();
		service.update(question);
		
		final Question questionUpdate = service.findById(questionA.getId());
		assertEquals("Questao001 Mock", questionUpdate.getDescription());
		assertFalse(questionUpdate.isEnable());
	}
	
	@Test
	public void desc() {
		List<Question> questions = service.questionList();
		
		assertEquals(0, questions.size());
	}
	

}
