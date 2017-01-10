/*
 * @(#)MapSkillsApplication.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
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
