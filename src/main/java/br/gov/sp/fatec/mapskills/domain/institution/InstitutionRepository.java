/*
 * @(#)MentorRepository.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 * A classe <code>InstitutionRepository</code> é responsável por realizar as
 * transacionalidades referentes as institutições
 * @author Marcelo
 *
 */
public interface InstitutionRepository extends CrudRepository<Institution, Long> {
	
	public Institution findById(final long id);
	public Institution findByCode(final String code);
	
	@Query("SELECT ins.gameThemeId FROM Institution ins WHERE ins.code = ?1")
	@Transactional(readOnly = true)
	public Long findGameThemeIdByCode(final String code);
	
	/**
	 * retorna todos os resultados da quantidade de alunos que
	 * finalizaram e não finalizaram de uma maneira geral por curso de todas
	 * as instituicoes. colunas:
	 * ANO_SEMESTRE, INS_CODE, CRS_CODE, CURSO, NAO_FINALIZADOS e FINALIZADOS
	 * @param institutionCode
	 * @param year_semester
	 * @return
	 */
	@Query(value="SELECT * FROM INSTITUTION_STUDENTS_PROGRESS_VIEW RESULT "
			+ "WHERE RESULT.INS_CODE = ?1 AND RESULT.ANO_SEMESTRE = ?2", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<Object[]> getStudentsProgressByInstitution(final String institutionCode, final String year_semester);
	
	/**
	 * retorna todos os resultados da quantidade de alunos que
	 * finalizaram e não finalizaram sumarizado de maneira global.
	 * Ou seja a contabilização dos alunos ETEC e FATEC
	 * @param year_semester
	 * @return
	 */
	@Query(value="SELECT * FROM ADMIN_GLOBAL_STUDENTS_PROGRESS_VIEW RESULT "
			+ "WHERE RESULT.YEAR_SEMESTER = ?1", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<Object[]> getGlobalStudentsProgress(final String year_semester);
	
	/**
	 * 
	 * @param level
	 * @param year_semester
	 * @return
	 */
	@Query(value="SELECT * FROM ADMIN_LEVEL_STUDENTS_PROGRESS_VIEW RESULT "
			+ "WHERE RESULT.LEVEL = ?1 AND RESULT.YEAR_SEMESTER = ?2", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<Object[]> getLevelStudentsProgress(final String level, final String year_semester);

}
