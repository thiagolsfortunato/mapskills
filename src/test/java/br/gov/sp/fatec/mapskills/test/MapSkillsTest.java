package br.gov.sp.fatec.mapskills.test;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.mapskills.domain.question.Alternative;
import br.gov.sp.fatec.mapskills.domain.question.Multimedia;
import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.domain.question.Text;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

public abstract class MapSkillsTest {
	
	protected void cleanTables(final RepositoryService<?>... services) {
		for(final RepositoryService<?> service : services) {
			final String serviceName = service.getClass().getSimpleName();
			System.err.println("limpando dados da tabela " + serviceName.replace("Service", "").toUpperCase());
			service.deleteAll();
		}
	}
	
	protected List<Question> buildMockQuestions(final long themeId) {
		final List<Text> texts = buildMockTexts();
		final List<Alternative> alternatives = builderMockAlternatives(); 
		final Question questionA = new Question("Questao001 Mock", alternatives, texts, 1, themeId);
		final Question questionB = new Question("Questao002 Mock", alternatives, texts, 2, themeId);
		final Question questionC = new Question("Questao003 Mock", alternatives, texts, 3, themeId);
		final Question questionD = new Question("Questao004 Mock", alternatives, texts, 4, themeId);
		final Question questionE = new Question("Questao005 Mock", alternatives, texts, 5, themeId);
		final Question questionF = new Question("Questao006 Mock", alternatives, texts, 6, themeId);
		final Question questionG = new Question("Questao007 Mock", alternatives, texts, 7, themeId);
		final Question questionH = new Question("Questao008 Mock", alternatives, texts, 8, themeId);
		final List<Question> questions = new ArrayList<>(8);
		questions.add(questionA);
		questions.add(questionB);
		questions.add(questionC);
		questions.add(questionD);
		questions.add(questionE);
		questions.add(questionF);
		questions.add(questionG);
		questions.add(questionH);
		return questions;
	}
	
	protected List<Alternative> builderMockAlternatives() {
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
	
	protected List<Text> buildMockTexts() {
		final List<Text> texts = new ArrayList<>();
		texts.add(new Text("TextoMock001", new Multimedia("http://site/img/001")));
		texts.add(new Text("TextoMock002", new Multimedia("http://site/img/002")));
		texts.add(new Text("TextoMock003", new Multimedia("http://site/img/003")));
		return texts;
	}

}
