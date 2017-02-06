package br.gov.sp.fatec.mapskills.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class AuthenticationTest extends AbstractApplicationTest {
		
	@Autowired
	private InstitutionService institutionService;
	/**
	 * sempre depois de realizar um teste, ira limpar os
	 * registros do banco em memoria.
	 */
	@After
	public void down() {
		institutionService.deleteAll();
	}
	
	@Test
	public void loginTest() throws Exception {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), 
				"Student MockE", "1289003400", "aluno@fatec.sp.gov.br", encoder.encode("mudar@123"));
		
		institutionService.saveStudent(student);
		
		mockMvc.perform(post("/login")
			.param("username", "aluno@fatec.sp.gov.br")
			.param("password", "mudar@123")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(status().isOk());
	}
	
	@Test
	public void jwtTest() throws Exception {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), 
				"Student MockE", "1289003400", "aluno@fatec.sp.gov.br", encoder.encode("mudar@123"));
		
		institutionService.saveStudent(student);

		mockMvc.perform(post("/login")
			.param("username", "aluno@fatec.sp.gov.br")
			.param("password", "mudar@123")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andReturn()
			.getResponse()
			.containsHeader(AUTHORIZATION);
	}

}
