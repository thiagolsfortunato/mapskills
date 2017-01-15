/*
 * @(#)MentorController.java 1.0 03/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.StudentPoiParser;
import br.gov.sp.fatec.mapskills.restapi.wrapper.CourseListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.CourseWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InputStreamWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentWrapper;

/**
 * A classe <code>MentorController</code> é responsável por conter todas
 * rotas (uri's) do perfil mentor da aplicação.
 * 
 * @author Marcelo
 *
 */
@RestController
public class MentorController {
	
	@Autowired
	private InstitutionService institutionService;
	
	/**
	 * Metodo que realiza o cadastro de uma lista de alunos por meio de um aquivio
	 * excel (.xlsx) feito pelo perfil <code>MENTOR</code>
	 * @param inputStreamWrapper
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload/students", method = RequestMethod.POST)
	public ResponseEntity<?> importStudents(@RequestBody final InputStreamWrapper inputStreamWrapper) throws Exception {
		final StudentPoiParser studentPoi = new StudentPoiParser();
		final List<Student> students = studentPoi.toObjectList(inputStreamWrapper.getInputStream());
		institutionService.saveStudents(students);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Metodo que realiza o cadastro de um aluno realizado pelo perfil <code>MENTOR</code>
	 * @param studentWrapper
	 * @return
	 */
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ResponseEntity<?> saveStudent(@RequestBody final StudentWrapper studentWrapper) {
		institutionService.saveStudent(studentWrapper.getStudent());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public ResponseEntity<?> saveCourse(@RequestBody final CourseWrapper courseWrapper) {
		institutionService.saveCourse(courseWrapper.getCourse());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Metodo que retorna todos alunos de um determinada instituicao, atraves do seu codigo.
	 * realizado pelo perfil <code>MENTOR</code>
	 * @param institutionCode
	 * @return
	 */
	@RequestMapping(value = "/institution/{institutionCode}/students", method = RequestMethod.GET)
	public ResponseEntity<StudentListWrapper> getAllStudentsByInstitution(
			@PathVariable("institutionCode") final String institutionCode) {
		
		final Collection<Course> courses = new ArrayList<>(); 
		final Collection<Student> students = new ArrayList<>();
		courses.addAll(institutionService.findAllCoursesByInstitutionCode(institutionCode));
		students.addAll(institutionService.findAllStudentsByInstitution(institutionCode));
		final StudentListWrapper studentsWrapper = new StudentListWrapper(students, courses);
		return new ResponseEntity<>(studentsWrapper, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/institution/{institutionCode}/courses", method = RequestMethod.GET)
	public ResponseEntity<CourseListWrapper> getAllCoursesByInstitution(
			@PathVariable("institutionCode") final String institutionCode) {
		
		final Collection<Course> allCourses = new ArrayList<>();
		allCourses.addAll(institutionService.findAllCoursesByInstitutionCode(institutionCode));
		final CourseListWrapper coursesWrapper = new CourseListWrapper(allCourses);
		return new ResponseEntity<>(coursesWrapper, HttpStatus.OK);
	}

}
