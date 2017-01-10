/*
 * @(#)SceneService.java 1.0 09/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.scene;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;
import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEventRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class SceneService implements RepositoryService<Scene> {
	
	@Autowired
	private SceneRepository sceneRepo;
	
	@Autowired
	private AnswerEventRepository answerRepo;

	@Override
	public void deleteAll() {
		sceneRepo.deleteAll();
		answerRepo.deleteAll();
	}
	
	public void save(final Scene scene) {
		final int index = nextIndex(scene.getGameThemeId());
		scene.putIndex(index);
		sceneRepo.save(scene);
	}
	
	public void updateIndex(final Collection<Scene> scenes) {
		sceneRepo.save(scenes);
	}
	
	public void save(final Collection<Scene> scenes) {
		//int index;
		for(final Scene scene : scenes) {
			//index = nextIndex(scene.getGameThemeId());
			//scene.putIndex(index);
			this.save(scene);
		}
	}
	/**
	 * Método que recupera todas as cenas habilitadas de um tema
	 * @return
	 */
	public Collection<Scene> findAllByGameThemeId(final long gameThemeId) {
		return sceneRepo.findAllByGameThemeId(gameThemeId);
	}
	
	/**
	 * Método que recupera o próximo index da cena válida, de determinado tema 
	 * @param themeId
	 * @return
	 */
	public int nextIndex(final long themeId) {
		return sceneRepo.findNextIndex(themeId);
	}
	
	public void saveAnswer(final AnswerEvent answerContext) {
		answerRepo.save(answerContext);
	}
	
	public List<Object[]> getResultByStudentId(final long studentId) {
		return answerRepo.findResultByStudentId(studentId);
	}

}
