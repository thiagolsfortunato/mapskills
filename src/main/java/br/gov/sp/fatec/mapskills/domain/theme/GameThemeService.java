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
	
	private GameThemeRepository themeRepo;
	private QuestionRepository questionRepo;
	
	@Override
	public void deleteAll() {
		themeRepo.deleteAll();
		questionRepo.deleteAll();
	}

	public GameTheme findById(final long id) {
		return themeRepo.findById(id);
	}
	
	public void save(final GameTheme theme) {
		themeRepo.save(theme);
	}
	
	public void save(final List<GameTheme> themes) {
		themeRepo.save(themes);
	}

	public Collection<GameTheme> findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		for(final GameTheme theme : themeRepo.findAll()) {
			themes.add(theme);
		}
		return themes;
	}
	/**
	 * Método que retorna todas as questões que estão ativas de um determinado tema
	 * @param id
	 * @return
	 */
	public Collection<Question> findAllQuestionsEnableByThemeId(final long id) {
		return questionRepo.findAllByThemeIdAndEnable(id, true);
	}

	@Autowired
	public void setGameThemeRepository(final GameThemeRepository repository) {
		this.themeRepo = repository;
	}
	
	@Autowired
	public void setQuestionRepository(final QuestionRepository repository) {
		this.questionRepo = repository;
	}
	
}
