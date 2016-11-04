/*
 * @(#)GameThemeService.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.theme;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

public class GameThemeService implements RepositoryService<GameTheme> {
	
	private GameThemeRepository repository;

	@Override
	public GameTheme findById(final int id) {
		return repository.findById(id);
	}
	
	public void create(final GameTheme theme) {
		repository.save(theme);
	}
	
	@Autowired
	public void setGameThemeRepository(final GameThemeRepository repository) {
		this.repository = repository;
	}

}
