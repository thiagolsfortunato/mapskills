package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.question.Alternative;
import br.gov.sp.fatec.mapskills.domain.question.Multimedia;
import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.domain.question.QuestionService;
import br.gov.sp.fatec.mapskills.domain.question.Text;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class QuestionTest {
	
	@Autowired
	QuestionService service;

	@Test
	public void save() {
		final List<Alternative> alternatives = builderMockAlternatives();
		final List<Text> texts = buildMockTexts();
		final Question question = new Question("Questao002 Mock", alternatives, texts, 1);
		service.create(question);
		
		assertEquals("Questao002 Mock", service.findById(question.id()).description());
	}

	@Test
	public void update() {
		final int id = 2;
		final Question question = service.findById(id);
		question.changeDescription("Questao002 Mock alt");
		question.changeAlternatives(builderMockAlternatives());
		service.create(question);
		
		assertEquals("Questao002 Mock alt", service.findById(id).description());
	}
	
	@Test
	public void desc() {
		List<Question> questions = service.questionList();
		
		assertEquals(1, questions.get(0).id());
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
