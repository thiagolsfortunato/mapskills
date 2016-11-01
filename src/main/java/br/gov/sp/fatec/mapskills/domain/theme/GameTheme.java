/*
 * @(#)GameTheme.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.theme;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.mapskills.domain.question.Question;

public class GameTheme {
	
	private final List<Question> questions = new ArrayList<>();
	
	public GameTheme(final List<Question> questions) {
		this.questions.clear();
		this.questions.addAll(questions);
	}

}
