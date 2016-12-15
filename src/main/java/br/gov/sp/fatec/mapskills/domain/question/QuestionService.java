/*
 * @(#)QuestionService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class QuestionService implements RepositoryService<Question> {

	private QuestionRepository questionRepository;
	
	/**
	 * Método que recupera o próximo index da questão valida, de determinado tema 
	 * @param themeId
	 * @return
	 */
	public int nextIndex(final long themeId) {
		return questionRepository.findNextIndex(themeId);
	}
	
	public void create(final Question question) {
		final int nextIndex = questionRepository.findNextIndex(question.getThemeId()); 
		question.putIndex(nextIndex);
		questionRepository.save(question);
	}
	
	public void create(final List<Question> questions) {
		for(final Question question : questions) {
			this.create(question);
		}
	}
	
	public void update(final Question question) {
		questionRepository.save(question);
	}

	public Question findById(final long id) {
		return questionRepository.findById(id);
	}
	
	public List<Question> questionList() {
		return questionRepository.questionList();
	}
	
	@Autowired
	public void setQuestionRespository(final QuestionRepository repository) {
		this.questionRepository = repository;
	}

}
