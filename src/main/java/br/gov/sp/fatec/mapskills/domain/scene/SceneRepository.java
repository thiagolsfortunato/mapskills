/*
 * @(#)SceneRepository.java 1.0 09/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.scene;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * A interface {@link SceneRepository}
 *
 * @author Marcelo
 * @version 1.0 09/01/2017
 */
public interface SceneRepository extends CrudRepository<Scene, Long> {
	
	/**
	 * Metodo recupera o proximo index valido para uma questao de um tema.
	 * @param themeId
	 * @return proximo index
	 */
	@Query("SELECT (COUNT(scene.id)) FROM Scene scene WHERE scene.gameThemeId = ?1")
	public int findNextIndex(final long themeId);
	
	/**
	 * BUSCAR TODAS CENAS ORDENADAS E AINDA NÃO RESPONDIDAS POR UM
	 * DETERMINADO ALUNO DE UMA INSTITUIÇÃO QUE TEM UM TEMA ATIVO
	 * @param studentId
	 * @return lista de cenas
	 */
	@Query("SELECT scene FROM Scene scene "
			+ "INNER JOIN Institution ins ON scene.gameThemeId = ins.gameThemeId "
			+ "INNER JOIN Student stu ON stu.ra.institutionCode = ins.code "
			+ "WHERE scene.id > "
			+ "	(SELECT COALESCE(MAX(event.sceneIndex + 1), 0) FROM AnswerEvent event "
			+ "		INNER JOIN Student stud ON event.studentId = stud.id "
			+ "		WHERE event.studentId = ?1) "
			+ "AND stu.completed = FALSE "
			+ "AND stu.id = ?1 "
			+ "ORDER BY scene.index ASC")
	public Collection<Scene> findAllNotAnsweredByStudent(final long studentId);
	
	/**
	 * Metodo que recupera todas cenas por um determinado id.
	 */
	public Collection<Scene> findAllByGameThemeIdOrderByIndexAsc(final long gameThemeId);

	
}
