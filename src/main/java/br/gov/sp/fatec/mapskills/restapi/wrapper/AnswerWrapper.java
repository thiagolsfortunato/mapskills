/* @(#)AnswerWrapper.java 1.0 04/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;
import br.gov.sp.fatec.mapskills.restapi.serializer.AnswerDeserializer;

@JsonDeserialize(using = AnswerDeserializer.class)
public class AnswerWrapper {
	
	private final AnswerEvent answerContext;
	
	public AnswerWrapper(final AnswerEvent answerContext) {
		this.answerContext = answerContext;
	}
	
	public AnswerEvent getAnswerContext() {
		return answerContext;
	}

}
