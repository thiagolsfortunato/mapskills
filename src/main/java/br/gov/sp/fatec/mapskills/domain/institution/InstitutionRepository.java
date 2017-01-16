/*
 * @(#)MentorRepository.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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
	public Long findGameThemeIdByCode(final String code);

}
