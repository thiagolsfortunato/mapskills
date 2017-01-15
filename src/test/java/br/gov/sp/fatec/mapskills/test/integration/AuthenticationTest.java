package br.gov.sp.fatec.mapskills.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Login;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class AuthenticationTest extends AbstractApplicationTest {
	
	@Autowired
	private InstitutionService institutionService;
	
	@Test
	public void loginTest() throws Exception {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), "Student MockE", "1289003400", "student@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(student);
		final ObjectMapper objectMapper = new ObjectMapper();
		final String body = objectMapper.writeValueAsString(new Login("student@fatec.sp.gov.br","mudar@123"));
		mockMvc.perform(post("/login")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
	}

}
