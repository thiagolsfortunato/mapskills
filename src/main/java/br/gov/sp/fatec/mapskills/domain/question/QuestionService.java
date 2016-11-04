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

	private QuestionRepository questionRepository;
	
	public void create(final Question obj) {
		questionRepository.save(obj);
	}

	public Question findById(final int id) {
		return questionRepository.findById(id);
	}
	
	public List<Question> questionList() {
		return questionRepository.questionList();
	}
	
	@Autowired(required = true)
	public void setQuestionRespository(final @Qualifier("questionRepository") QuestionRepository repository) {
		this.questionRepository = repository;
	}

}
