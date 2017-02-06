/*
 * @(#)ApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	@Test
	public void getAllInstitutionsForbiddenTest() throws Exception {
		
		this.mockMvc.perform(get(BASE_PATH + "/institutions")
				.with(user("admin"))
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isForbidden());
	}
	
	@Test
	public void postSkill() throws Exception {
		final Skill skill = new Skill("liderança", "avalia...");
		final String bodyInput = objectMapper.writeValueAsString(skill);
		
		when(jwtAuthenticationManager.authenticate(Mockito.any(Authentication.class)))
			.thenReturn(getAdminMock());
		
		this.mockMvc.perform(post(BASE_PATH + "/skill")
				.header(AUTHORIZATION, Mockito.anyString())
				.content(bodyInput)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
		
		assertEquals(skillService.findById(1).getType(), skill.getType());
	}
	
	private Authentication getAdminMock() {
		return new PreAuthenticatedAuthentication(new Administrator("admin", "admin@cps.sp.gov.br", "admin"));
	}

}
