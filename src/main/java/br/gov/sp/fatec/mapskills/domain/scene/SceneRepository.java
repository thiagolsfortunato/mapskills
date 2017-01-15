/*
 * @(#)SceneRepository.java 1.0 09/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.scene;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SceneRepository extends CrudRepository<Scene, Long> {
	
	/**
	 * Método recupera o próximo index valido para uma questão de um tema
	 * @param themeId
	 * @return
	 */
	@Query("SELECT (COUNT(*)) FROM Scene s WHERE s.gameThemeId = ?1")
	public int findNextIndex(final long themeId);
	
	/**
	 * BUSCAR TODAS CENAS ORDENADAS E AINDA NÃO RESPONDIDAS POR UM
	 * DETERMINADO ALUNO DE UMA INSTITUIÇÃO QUE TEM UM TEMA ATIVO
	 * @param studentId
	 * @return lista de cenas
	 */
	@Query("SELECT s FROM Scene s WHERE s.id NOT IN "
			+ "(SELECT event.sceneId FROM AnswerEvent event "
			+ "INNER JOIN Scene sce ON event.sceneId = sce.id "
			+ "INNER JOIN Institution inst ON sce.gameThemeId = inst.gameThemeId "
			+ "WHERE event.studentId = ?1) ORDER BY s.index")
	public Collection<Scene> findAllNotAnsweredByStudent(final long studentId);
	
	/**
	 * Método que recupera todas cenas por um determinado id
	 * @param gameThemeId
	 * @return
	 */
	public Collection<Scene> findAllByGameThemeId(final long gameThemeId);

	
}
