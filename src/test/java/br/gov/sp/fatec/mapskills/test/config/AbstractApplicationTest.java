/*
 * @(#)AbstractApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;

import javax.servlet.Filter;

import org.apache.commons.io.IOUtils;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.config.WebConfig;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.student.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;
import br.gov.sp.fatec.mapskills.test.wrapper.InstitutionWrapperTest;

/**
 * 
 * A classe {@link AbstractApplicationTest} representa as configuracoes
 * globais de teste, para todos outros testes.
 *
 * @author Marcelo
 * @version 1.0 13/01/2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringContextTestConfiguration.class, WebConfig.class})
public abstract class AbstractApplicationTest {
	
	protected static final String AUTHORIZATION = "Authorization";
	protected static final String JSON_UTF8_MEDIA_TYPE = MediaType.APPLICATION_JSON_UTF8_VALUE;
		
	@Autowired
	protected AbstractPreAuthenticatedProcessingFilter filter;
	
	@Autowired
    protected WebApplicationContext wac;
	
	@Autowired
    private Filter springSecurityFilterChain;
	
	@Autowired
	protected PasswordEncoder encoder;
	
	@Autowired
	protected ObjectMapper objectMapper;
	
	protected MockMvc mockMvc;
	
	/**
	 * configuração inicial para mockar os teste de integração
	 */
    protected void setUpContext() {
		mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .addFilters(springSecurityFilterChain)
                .build();
    }
	/**
	 * metodo que limpa todas as tabelas da service,
	 * para que um teste não influenciem nos resultados
	 * de outros de outros testes.
	 * 
	 * @param service
	 */
	protected void cleanTables(final RepositoryService service) {
		service.deleteAll();
	}
	
	protected ResultActions mockMvcPerformPost(final String request, final String body) throws Exception {
		return mockMvc.perform(post(request)
				.header(AUTHORIZATION, Mockito.anyString())
				.content(body)
				.contentType(JSON_UTF8_MEDIA_TYPE));
	}
	
	protected ResultActions mockMvcPerformGet(final String request) throws Exception {
		return mockMvc.perform(get(request)
				.accept(MediaType.parseMediaType(JSON_UTF8_MEDIA_TYPE)));
	}
	
	protected ResultActions mockMvcPerformWithMockHeaderGet(final String request) throws Exception {
		return mockMvc.perform(get(request)
				.header(AUTHORIZATION, Mockito.anyString())
				.accept(MediaType.parseMediaType(JSON_UTF8_MEDIA_TYPE)));
	}
	
	protected ResultActions mockMvcPerformWithMockHeaderPut(final String request, final String body) throws Exception {
		return mockMvc.perform(put(request)
				.header(AUTHORIZATION, Mockito.anyString())
				.content(body)
				.contentType(MediaType.parseMediaType(JSON_UTF8_MEDIA_TYPE)));
	}
	
	protected ResultActions mockMvcPerformLogin(final String username, final String password) throws Exception {
		return mockMvc.perform(post("/login")
				.param("username", username)
				.param("password", password)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED));
	}
	
	protected Collection<Student> getStudentsMock() {
		final Collection<Student> students = new ArrayList<>(4);
		students.add(new Student(new AcademicRegistry("1460281423010", "146", "028"), 
						"Student MockA", "1289003400", "studentA@fatec.sp.gov.br", "mudar@123"));
		students.add(new Student(new AcademicRegistry("1460281423020", "146", "028"), 
				"Student MockB", "1289003400", "studentB@fatec.sp.gov.br", "mudar@123"));
		students.add(new Student(new AcademicRegistry("1460281423030", "146", "028"), 
				"Student MockC", "1289003400", "studentC@fatec.sp.gov.br", "mudar@123"));
		students.add(new Student(new AcademicRegistry("1460281423040", "146", "028"), 
				"Student MockD", "1289003400", "studentD@fatec.sp.gov.br", "mudar@123"));
		
		return students;
	}
	
	protected Student getOneStudent() {
		return  new Student(new AcademicRegistry("1460281423050", "146", "028"), 
				"Student MockE", "1289003400", "aluno@fatec.sp.gov.br", encoder.encode("mudar@123"));
	}
	
	protected InstitutionWrapperTest getInstitutionClient() {
		return new InstitutionWrapperTest(getOneInstitution());
	}
	
	protected Institution getOneInstitution() {
		final Institution institution = new Institution("146", "33177625000182", "Fatec-Teste", InstitutionLevel.SUPERIOR, "Cidade-Teste");
		institution.addMentor(new Mentor("Fabiola Vaz", "146", "fabiola.vaz@fatec.sp.gov.br", "mudar@123"));
		return institution;
	}
	
	protected Collection<Skill> getSkillsMock() {
		final Collection<Skill> skills = new ArrayList<>();
		skills.add(Skill.builder().type("Liderança").description(" liderança..").build());
		skills.add(Skill.builder().type("Visão de Futuro").description(" visão..").build());
		skills.add(Skill.builder().type("Gestão de Tempo").description(" gestão..").build());
		return skills;
	}
	
	protected String parseFileToJson(final String fileName) throws IOException {
		final InputStream inputStream = getClass().getClassLoader().getResource(fileName).openStream();
		final String excelBase64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(inputStream));
		
		final String obj = objectMapper.writeValueAsString(String.format("{ base64 : %s }", excelBase64));
		final String json = obj.replace(" ", "\"").substring(1, obj.length()-1);
		return json;
	}

}
