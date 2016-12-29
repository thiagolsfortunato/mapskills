package br.gov.sp.fatec.mapskills.application;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;
import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEventRepository;

public class MapSkillsApplication {
	
	@Autowired
	private AnswerEventRepository answerEventRepository; 
	
	public void answerQuestion(final AnswerEvent answerEvent) {
		
	}

}
