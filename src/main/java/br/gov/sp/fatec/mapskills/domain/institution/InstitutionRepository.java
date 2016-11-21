/*
 * @(#)MentorRepository.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.data.repository.CrudRepository;

public interface InstitutionRepository extends CrudRepository<Institution, Integer> {
	
	public Institution findByCode(final int code);

}
