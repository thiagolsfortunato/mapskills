/*
 * @(#)MentorTest.java 1.0 15/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.authentication.PreAuthenticatedAuthentication;
import br.gov.sp.fatec.mapskills.authentication.jwt.JwtAuthenticationManager;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class InstitutionTest extends AbstractApplicationTest {
	
	private static final String BASE_PATH = "/institution";
	
	@Mock
	private JwtAuthenticationManager jwtAuthenticationManager;
	
	@Autowired
	private InstitutionService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	/**
	 * autentica um usuario mentor para que passe pelo
	 * spring security
	 */
	@Before
	public void setUp() {
		super.setUpContext();
		MockitoAnnotations.initMocks(this);
    	filter.setAuthenticationManager(jwtAuthenticationManager);
	}
	
	@After
	public void cleanTables() {
		super.cleanTables(service);
	}
	
	@Test
	public void saveStudent() throws Exception {
		mockMentorAuthentication();
		
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), 
						"Student MockE", "1289003400", "studentE@fatec.sp.gov.br", "mudar@123");
		
		final String bodyJson = objectMapper.writeValueAsString(student);
		
		super.mockMvcPerformPost(BASE_PATH.concat("/student"), bodyJson)
			.andExpect(status().isOk());
		
		assertTrue(service.findStudentByRa(student.getRa()).getName().equals(student.getName()));
	}
	
	@Test
	public void uploadStudentsFromExcel() throws Exception {
		mockMentorAuthentication();
		
		final InputStream inputStream = getClass().getClassLoader().getResource("student.xlsx").openStream();
		final String excelBase64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(inputStream));
		
		final String obj = objectMapper.writeValueAsString(String.format("{ base64 : %s }", excelBase64));
		final String json = obj.replace(" ", "\"").substring(1, obj.length()-1);
		
		super.mockMvcPerformPost(BASE_PATH.concat("/upload/students"), json)
			.andExpect(status().isOk());
		
		assertEquals(2, service.findAllStudentsByInstitution("146").size());
	}
	
	@Test
	public void saveCourse() throws Exception {
		mockMentorAuthentication();
		
		final Course course = new Course("100", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146");
		final String json = objectMapper.writeValueAsString(course);
		
		super.mockMvcPerformPost(BASE_PATH.concat("/course"), json)
			.andExpect(status().isOk());
		
		assertEquals(1, service.findAllCoursesByInstitutionCode("146").size());
	}
	
	@Test
	public void findAllStudentsByInstitutionCode() throws Exception {
		mockMentorAuthentication();
				
		service.saveCourse(new Course("028", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146"));
		service.saveStudents(getStudentsMock());
		
		final MvcResult result = super.mockMvcPerformWithMockHeaderGet(BASE_PATH.concat("/146/students")).andReturn();
		
		final String jsonResponse = result.getResponse().getContentAsString();
		final Object[] allStudentsAsArray = objectMapper.readValue(jsonResponse, Object[].class);
		final Collection<Object> allStudents = new ArrayList<>(4);
		allStudents.addAll(Arrays.asList(allStudentsAsArray));
		
		assertEquals(4, allStudents.size());
	}
	
	@Test
	public void findAllCoursesByInstitution() throws Exception {
		mockMentorAuthentication();
		
		service.saveCourse(new Course("100", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146"));
		service.saveCourses(getCoursesMock());
		
		final MvcResult result = super.mockMvcPerformWithMockHeaderGet(BASE_PATH.concat("/146/courses")).andReturn();
		
		final String jsonResponse = result.getResponse().getContentAsString();
		final Course[] allCourseAsArray = objectMapper.readValue(jsonResponse, Course[].class);
		final Collection<Course> allCourses = Arrays.asList(allCourseAsArray);
		
		assertEquals(4, allCourses.size());
	}
	
	private void mockMentorAuthentication() {
		when(jwtAuthenticationManager.authenticate(Mockito.any(Authentication.class)))
			.thenReturn(getMentorMock());
	}
	
	private Authentication getMentorMock() {
		return new PreAuthenticatedAuthentication(new Mentor("mentor", "146","admin@cps.sp.gov.br", "admin"));
	}
	
	private Collection<Course> getCoursesMock() {
		final Collection<Course> courses = new ArrayList<>(3);
		courses.add(new Course("100", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146"));
		courses.add(new Course("200", "logistica", CoursePeriod.NOTURNO, "146"));
		courses.add(new Course("300", "analise de sistemas", CoursePeriod.NOTURNO, "146"));
		return courses;
	}

}
