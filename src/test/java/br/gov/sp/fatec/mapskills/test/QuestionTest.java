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
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class QuestionTest {
	
	@Autowired
	private QuestionService service;

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
		service.create(questionA);
		service.create(questionB);
		service.create(questionC);
			
		assertEquals(3, service.questionList().size());
	}
	
	@Test
	public void nextIndex() {
		final int index = service.nextIndex(1);
		
		assertEquals(2, index);
	}

	@Test
	public void update() {
		final int ID = 4;
		final Question question = service.findById(ID);
		question.changeDescription("Questao002 Mock deprecated");
		question.disable();
		service.update(question);
		
		assertEquals("Questao002 Mock deprecated", service.findById(ID).getDescription());
		assertFalse(service.findById(ID).isEnable());
	}
	
	@Test
	public void desc() {
		List<Question> questions = service.questionList();
		
		assertEquals(3, questions.size());
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
