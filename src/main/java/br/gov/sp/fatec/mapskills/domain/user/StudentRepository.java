/* @(#)StudentRepository.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s WHERE s.ra.courseCode = ?1 AND s.ra.institutionCode = ?2")
	public List<Student> findAllByCourseAndInstitution(final String courseCode, final String institutionCode);
	
	public List<Student> findAll();
	
	public Student findByRaRa(final String ra); 
	/**
	 * recupera todos alunos em detalhes de uma instituição
	 * @param institutionCode
	 * @return
	 */
	public List<Student> findAllByRaInstitutionCode(final String institutionCode);

}
