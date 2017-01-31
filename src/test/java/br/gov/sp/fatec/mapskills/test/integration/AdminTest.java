/*
 * @(#)ApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class AdminTest extends AbstractApplicationTest {
	
	private static final String BASE_PATH = "/admin";
	
	@Autowired
	private SkillService skillService;
	
	@Test
	public void adminGetInstitutionsTest() throws Exception {
		
		this.mockMvc.perform(get(BASE_PATH + "/institutions")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void adminPostSkill() throws Exception {
		final Skill skill = new Skill("liderança", "avalia...");
		final ObjectMapper objectMapper = new ObjectMapper();
		final String bodyInput = objectMapper.writeValueAsString(skill);
		this.mockMvc.perform(post(BASE_PATH + "/skill")
				.content(bodyInput)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
		
		assertEquals(skillService.findById(1).getType(), skill.getType());
	}
	

}
