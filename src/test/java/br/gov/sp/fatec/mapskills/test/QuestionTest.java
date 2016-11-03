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
import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.domain.question.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class QuestionTest {
	
	@Autowired
	QuestionService service;

	@Test
	public void save() {
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question("Questao002 Mock", alternatives, 1, 1);
		service.create(question);
		
		assertEquals("Questao002 Mock", service.findById(question.id()).description());
	}

	@Test
	public void update() {
		final int id = 2;
		final Question question = service.findById(id);
		question.changeDescription("Questao002 Mock alt");
		question.setStatus(false);
		question.changeAlternatives(builderMockAlternatives());
		question.changeIndex(2);
		service.create(question);
		
		assertEquals("Questao002 Mock alt", service.findById(id).description());
	}
	
	@Test
	public void desc() {
		List<Question> questions = service.questionList();
		
		assertEquals(1, questions.get(0).index());
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

}
