/*
 * @(#)MentorTest.java 1.0 15/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class MentorTest extends AbstractApplicationTest {
	
	@Autowired
	private InstitutionService service;
	
	@Test
	public void getInstitutionCodeByUserId() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "147", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("147", "123456789000", "Jessen Vidal", "São José", mentor);
		service.saveInstitution(fatec);
	}

}
