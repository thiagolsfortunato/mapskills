/*
 * @(#)GameThemeService.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
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
/**
 * 
 * A classe {@link GameThemeService} contem todas as regras de negocio
 * que diz respeito a classe <code>GameTheme</code>.
 *
 * @author Marcelo
 * @version 1.0 04/11/2016
 */
@Service
public class GameThemeService implements RepositoryService {
	
	private GameThemeRepository themeRepo;
	private SceneRepository sceneRepo;
	
	@Override
	public void deleteAll() {
		themeRepo.deleteAll();
	}
	/**
	 * Realiza busca de um tema por seu id.
	 * @param id
	 */
	public GameTheme findById(final long id) {
		return themeRepo.findById(id);
	}
	/**
	 * Realiza persistencia de um tema caso nao exista.
	 * @param theme
	 */
	public GameTheme save(final GameTheme theme) {
		return themeRepo.save(theme);			
	}
	/**
	 * Realiza persistencia de uma lista de temas
	 * verificando se ja estão cadastrados.
	 * @param themes
	 */
	public Collection<GameTheme> save(final Collection<GameTheme> themes) {
		final Collection<GameTheme> themesSaved = new ArrayList<>(themes.size());
		for(final GameTheme theme : themes) {
			themesSaved.add(this.save(theme));	
		}
		return themesSaved;
	}
	/**
	 * Metodo que retorna todos temas cadastrados na aplicacao.
	 * @return lista
	 */
	public Collection<GameTheme> findAllThemes() {
		final List<GameTheme> themes = new ArrayList<>();
		for(final GameTheme theme : themeRepo.findAll()) {
			themes.add(theme);
		}
		return themes;
	}
	/**
	 * Metodo que retorna todas as cenas que estao ativas de um determinado tema
	 * de uma determinada instituicao.
	 * @param themeId
	 * @return lista
	 */
	public Collection<Scene> findAllScenesByThemeId(final long themeId) {
		return sceneRepo.findAllByGameThemeIdOrderByIndexAsc(themeId);
	}
	
	public Collection<GameTheme> findAllThemesActivated() {
		return themeRepo.findAllByActive(true);
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
