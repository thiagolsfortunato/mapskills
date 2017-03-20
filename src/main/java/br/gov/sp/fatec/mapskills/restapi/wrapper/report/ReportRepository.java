/*
 * @(#)ReportRepository.java 1.0 18/03/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ReportRepository extends Repository<ReportDefaultData, Long>, JpaSpecificationExecutor<ReportDefaultData> {
	/**
	 * Recupera o valor das competencias de um aluno.
	 * @param studentId
	 * @return
	 */
	@Query(value="SELECT view.total FROM skill LEFT JOIN radar_result_view view ON skill.ski_type = view.skill_type "
			+ "WHERE view.user_id = ?1 OR view.user_id IS NULL ORDER BY skill.ski_id;", nativeQuery = true)
	public List<Object> findAllSkillsByStudentId(final long studentId);

}
