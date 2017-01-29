/*
 * @(#)MentorTest.java 1.0 15/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class InstitutionTest extends AbstractApplicationTest {
	
	@Autowired
	private InstitutionService service;
	
	@Test
	public void saveStudent() throws Exception {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), 
						"Student MockE", "1289003400", "studentE@fatec.sp.gov.br", "mudar@123");
		
		final ObjectMapper objectMapper = new ObjectMapper();
		final String body = objectMapper.writeValueAsString(student);
		
		this.mockMvc.perform(post("/student")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
	}

}
