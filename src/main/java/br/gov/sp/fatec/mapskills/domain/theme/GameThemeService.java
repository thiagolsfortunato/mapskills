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

import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class GameThemeService implements RepositoryService<GameTheme> {
	
	private GameThemeRepository themeRepo;
	private SceneRepository sceneRepo;
	
	@Override
	public void deleteAll() {
		themeRepo.deleteAll();
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
	
	/**
	 * Metodo que retorna todos temas cadastrados na aplicacao
	 * @return
	 */
	public Collection<GameTheme> findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		for(final GameTheme theme : themeRepo.findAll()) {
			themes.add(theme);
		}
		return themes;
	}
	/**
	 * Método que retorna todas as cenas que estão ativas de um determinado tema
	 * de uma determinada instituicao.
	 * @param themeId
	 * @return
	 */
	public Collection<Scene> findAllScenesByThemeId(final long themeId) {
		return sceneRepo.findAllByGameThemeId(themeId);
	}
	
	
	//=== Dependecy Inject ===

	@Autowired
	public void setGameThemeRepository(final GameThemeRepository repository) {
		this.themeRepo = repository;
	}
	
	@Autowired
	public void setSceneRepository(final SceneRepository repository) {
		this.sceneRepo = repository;
	}
	
}
