/*
 * @(#)GameThemeService.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.theme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.question.Question;
import br.gov.sp.fatec.mapskills.domain.question.QuestionRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class GameThemeService implements RepositoryService<GameTheme> {
	
	private GameThemeRepository repository;
	private QuestionRepository questionRepo;

	public GameTheme findById(final long id) {
		return repository.findById(id);
	}
	
	public void save(final GameTheme theme) {
		repository.save(theme);
	}	

	public Collection<GameTheme> findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		for(final GameTheme theme : repository.findAll()) {
			themes.add(theme);
		}
		return themes;
	}
	/**
	 * Método que retorna todas as questões que estão ativas de um determinado tema
	 * @param id
	 * @return
	 */
	public Collection<Question> findAllQuestionsIsEnableByThemeId(final long id) {
		return questionRepo.findAllByThemeIdAndEnable(id, true);
	}

	@Autowired
	public void setGameThemeRepository(final GameThemeRepository repository) {
		this.repository = repository;
	}
	
	@Autowired
	public void setQuestionRepository(final QuestionRepository repository) {
		this.questionRepo = repository;
	}
	
}
