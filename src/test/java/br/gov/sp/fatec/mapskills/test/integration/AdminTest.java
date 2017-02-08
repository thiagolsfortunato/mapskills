/*
 * @(#)ApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.authentication.PreAuthenticatedAuthentication;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class AdminTest extends AbstractApplicationTest {
	
	private static final String BASE_PATH = "/admin";
		
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Before
	public void setuUp() {
		super.setUpContext();
		super.setUpMockInitializer();
		
		when(jwtAuthenticationManager.authenticate(Mockito.any(Authentication.class)))
		.thenReturn(getAdminMock());
	}
	
	@After
	public void cleanTables() {
		super.cleanTables(skillService);
	}
	
	@Test
	public void getAllInstitutionsForbidden() throws Exception {
				
		super.mockMvcPerformGet(BASE_PATH.concat("/institutions"))
			.andExpect(status().isForbidden());
	}
	
	@Test
	public void postSkill() throws Exception {
		final Skill skill = new Skill("liderança", "avalia...");
		final String bodyInput = objectMapper.writeValueAsString(skill);

		super.mockMvcPerformPost(BASE_PATH.concat("/skill"), bodyInput)
			.andExpect(status().isOk());
		
		assertEquals(skillService.findById(1).getType(), skill.getType());
	}
	
	private Authentication getAdminMock() {
		return new PreAuthenticatedAuthentication(new Administrator("admin", "admin@cps.sp.gov.br", "admin"));
	}

}
