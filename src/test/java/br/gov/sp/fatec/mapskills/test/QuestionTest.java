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
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.mapskills.question.Alternative;
import br.gov.sp.fatec.mapskills.question.Question;
import br.gov.sp.fatec.mapskills.question.QuestionRepository;
import br.gov.sp.fatec.mapskills.spring.SpringRootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRootConfig.class, loader = AnnotationConfigContextLoader.class)
public class QuestionTest implements ApplicationTest {
	
	@Autowired
	QuestionRepository repository;

	@Test
	@Transactional
	public void save() {
		final List<Alternative> alternatives = builderMockAlternatives();
		final Question question = new Question("Quest�o002 Mock", alternatives, 1, 1);
		repository.save(question);
		
		assertEquals("Quest�o002 Mock", repository.findById(question.id()).description());
	}

	@Test
	@Transactional
	public void update() {
		final int id = 2;
		final Question question = repository.findById(id);
		question.changeDescription("Quest�o002 Mock alt");
		question.setStatus(false);
		question.changeAlternatives(builderMockAlternatives());
		question.changeIndex(2);
		repository.save(question);
		
		assertEquals("Quest�o002 Mock alt", repository.findById(id).description());
	}
	
	@Test
	@Transactional
	public void desc() {
		List<Question> questions = repository.questionList();
		
		assertEquals(new Integer("1"), questions.get(0).index());
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
