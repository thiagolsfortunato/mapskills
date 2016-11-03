/*
 * @(#)QuestionService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;


public class QuestionService implements RepositoryService<Question> {

	@Autowired(required = true)
	@Qualifier("questionRepository")
	QuestionRepository repository;
	
	public void create(final Question obj) {
		repository.save(obj);
	}

	public Question findById(final int id) {
		return repository.findById(id);
	}
	
	public List<Question> questionList() {
		return repository.questionList();
	}

}
