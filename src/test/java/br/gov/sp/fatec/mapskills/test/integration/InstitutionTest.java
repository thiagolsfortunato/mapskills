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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.mapskills.authentication.PreAuthenticatedAuthentication;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;
import br.gov.sp.fatec.mapskills.test.wrapper.StudentWithCourse;

public class InstitutionTest extends AbstractApplicationTest {
	
	private static final String BASE_PATH = "/institution";
	
	@Autowired
	private InstitutionService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	/**
	 * autentica um usuario mentor para que passe pelo
	 * spring security
	 */
	@Before
	public void preparedAuthenticationMock() {
		when(jwtAuthenticationManager.authenticate(Mockito.any(Authentication.class)))
			.thenReturn(getMentorMock());
	}
	
	@After
	public void cleanTables() {
		service.deleteAll();
	}
	
	@Test
	public void saveStudent() throws Exception {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), 
						"Student MockE", "1289003400", "studentE@fatec.sp.gov.br", "mudar@123");
		
		final String bodyJson = objectMapper.writeValueAsString(student);
		
		this.mockMvc.perform(post(BASE_PATH + "/student")
				.header(AUTHORIZATION, Mockito.anyString())
				.content(bodyJson)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
		
		assertTrue(service.findStudentByRa(student.getRa()).getName().equals(student.getName()));
	}
	
	@Test
	public void uploadStudentsFromExcel() throws Exception {
		final InputStream inputStream = getClass().getClassLoader().getResource("student.xlsx").openStream();
		final String excelBase64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(inputStream));
		
		final String obj = objectMapper.writeValueAsString(String.format("{ base64 : %s }", excelBase64));
		final String json = obj.replace(" ", "\"").substring(1, obj.length()-1);
		this.mockMvc.perform(post(BASE_PATH + "/upload/students")
				.header(AUTHORIZATION, Mockito.anyString())
				.content(json)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
		
		assertEquals(2, service.findAllStudentsByInstitution("146").size());
	}
	
	@Test
	public void saveCourse() throws Exception {
		final Course course = new Course("100", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146");
		final String json = objectMapper.writeValueAsString(course);
		
		this.mockMvc.perform(post(BASE_PATH + "/course")
				.header(AUTHORIZATION, Mockito.anyString())
				.content(json)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk());
		
		assertEquals(1, service.findAllCoursesByInstitutionCode("146").size());
	}
	
	@Test
	public void findAllStudentsByInstitutionCode() throws Exception {
		service.saveCourse(new Course("028", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146"));
		service.saveStudents(getStudentsMock());
						
		final MvcResult result = this.mockMvc.perform(get(BASE_PATH + "/146/students")
				.header(AUTHORIZATION, Mockito.anyString())
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andReturn();
		
		final String jsonResponse = result.getResponse().getContentAsString();
		final StudentWithCourse[] allStudentsAsArray = objectMapper.readValue(jsonResponse, StudentWithCourse[].class);
		final Collection<StudentWithCourse> allStudents = new ArrayList<>();
		allStudents.addAll(Arrays.asList(allStudentsAsArray));
		
		assertEquals(4, allStudents.size());
				
	}
	
	@Test
	public void findAllCoursesByInstitution() throws Exception {
		service.saveCourse(new Course("100", "manutenção de aeronaves", CoursePeriod.NOTURNO, "146"));
		service.saveCourses(getCoursesMock());
		
		final MvcResult result = this.mockMvc.perform(get(BASE_PATH + "/146/courses")
				.header(AUTHORIZATION, Mockito.anyString())
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andReturn();
		
		final String jsonResponse = result.getResponse().getContentAsString();
		final Course[] allCourseAsArray = objectMapper.readValue(jsonResponse, Course[].class);
		final Collection<Course> allCourses = Arrays.asList(allCourseAsArray);
		
		assertEquals(4, allCourses.size());
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
	
	private Collection<Student> getStudentsMock() {
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

}
