/*
 * @(#)UserRepository.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findById(final int id);

	@Query("SELECT s FROM Student s INNER JOIN Course c ON s.courseCode() = c.code "
			+ "INNER JOIN Institution i ON c.institutionCode = i.code WHERE c.code = ?1 AND i.code = ?2")
	public Collection<Student> findAllStudentByCourse(final int courseCode, final int institutionCode);

	@Query("SELECT s FROM Student s INNER JOIN Institution i ON i.code = ?1")
	public Collection<Student> findAllStudentByInstitution(final int institutionCode);

	public User findByLogin(final Login login);
	

}
