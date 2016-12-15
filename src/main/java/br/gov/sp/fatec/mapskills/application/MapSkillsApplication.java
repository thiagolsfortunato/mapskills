package br.gov.sp.fatec.mapskills.application;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.question.AnswerEvent;
import br.gov.sp.fatec.mapskills.domain.question.AnswerEventRepository;

public class MapSkillsApplication {
	
	@Autowired
	private AnswerEventRepository answerEventRepository; 
	
	public void answerQuestion(final AnswerEvent answerEvent) {
		
	}

}
