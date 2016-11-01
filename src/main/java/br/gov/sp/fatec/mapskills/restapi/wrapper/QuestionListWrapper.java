/*
 * @(#)QuestionListWrapper.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.restapi.serializer.QuestionListSerializer;

@JsonSerialize(using = QuestionListSerializer.class)
public class QuestionListWrapper {
	
	private final List<Question> questions = new ArrayList<>();
	
	public QuestionListWrapper(final List<Question> questions) {
		this.questions.clear();
		this.questions.addAll(questions);
	}

}
