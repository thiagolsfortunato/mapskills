/*
 * @(#)QuestionRepository.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
		
	@Query("SELECT q FROM Question q ORDER BY q.index")
	public List<Question> questionList();
	
	public Question findById(final int id);

	/**
	 * Método que recupera todas questões de um determinado tema e que não esteja desabilitada
	 * @param themeId
	 * @param active
	 * @return
	 */
	public List<Question> findAllByThemeIdAndEnable(final int themeId, final boolean active);
	
	//MÉTODO PARA BUSCAR TODAS QUESTOES HABILITADAS E NÃO RESPONDIDAS DE UM DETERMINADO ALUNO
	
	/**
	 * Método recupera o próximo index valido para uma questão de um tema
	 * @param themeId
	 * @return
	 */
	@Query("SELECT (COUNT(*) + 1) FROM Question q INNER JOIN GameTheme t ON q.themeId = t.id WHERE t.id = ?1")
	public int findNextIndex(final int themeId);
	
}
