/*
 * @(#)AbstractApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.Filter;

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

import br.gov.sp.fatec.mapskills.config.WebConfig;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;
/**
 * A classe <code>AbstractApplicationTest</code> representa as configurações
 * globais de teste, para todos outros testes.
 * @author Marcelo
 *
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
	
	protected Institution getOneInstitution() {
		return new Institution("150", "33177625000182", "Fatec-Teste", "Cidade-Teste", 
				new Mentor("Fabiola Vaz", "150", "fabiola.vaz@fatec.sp.gov.br", "mudar@123"));
	}

}
