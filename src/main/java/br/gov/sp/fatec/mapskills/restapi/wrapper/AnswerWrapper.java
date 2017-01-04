package br.gov.sp.fatec.mapskills.restapi.wrapper;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;

public class AnswerWrapper {
	
	private final AnswerEvent answerContext;
	
	public AnswerWrapper(final AnswerEvent answerContext) {
		this.answerContext = answerContext;
	}
	
	public AnswerEvent getAnswerContext() {
		return answerContext;
	}

}
