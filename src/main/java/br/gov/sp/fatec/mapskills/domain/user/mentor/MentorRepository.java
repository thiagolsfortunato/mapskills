/*
 * @(#)MentorRepository.java 1.0 12/02/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user.mentor;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface MentorRepository extends CrudRepository<Mentor, Long> {
	
	public Collection<Mentor> findAllByInstitutionCode(final String institutionCode);
}
