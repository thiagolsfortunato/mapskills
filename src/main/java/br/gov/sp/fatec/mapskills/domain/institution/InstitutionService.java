/*
 * @(#)MentorService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.UserRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class InstitutionService implements RepositoryService<Institution> {
		
	private InstitutionRepository institutionRepository;
	private CourseRepository courseRepository;
	private UserRepository userRepository;
	private StudentRepository studentRepository;

	public void saveInstitution(final Institution institution) {
		institutionRepository.save(institution);
	}
	
	public void saveInstitutions(final List<Institution> institutions) {
		institutionRepository.save(institutions);
	}
	
	public void saveCourse(final Course course) {
		courseRepository.save(course);
	}
	
	public void saveCourses(final List<Course> courses) {
		courseRepository.save(courses);
	}
	
	public void updateInstitution(final Institution institution) {
		institutionRepository.save(institution);
	}

	public Institution findByCode(final int code) {
		return institutionRepository.findByCode(code);
	}
	
	public Collection<Institution> findAllInstitutions() {
		final List<Institution> institutions = new ArrayList<>();
		for(final Institution institution : institutionRepository.findAll()) {
			institutions.add(institution);
		}
		return institutions;
	}
	
	public Collection<Course> findAllCourses() {
		final List<Course> courses = new ArrayList<>();
		for(final Course course : courseRepository.findAll()) {
			courses.add(course);
		}
		return courses;
	}

	/**
	 * Método que recupera todos os cursos de uma determinada instituição
	 * @param code
	 * @return
	 */
	public Collection<Course> findAllCoursesByInstitution(final int code) {
		final List<Course> courses = new ArrayList<>();
		for(final Course course : courseRepository.findAllByInstitutionCode(code)) {
			courses.add(course);
		}
		return courses;
	}
	
	public Collection<Student> findAllStudentsByCourse(final int courseCode, final int institutionCode) {
		final List<Student> courses = new ArrayList<>();
		for(final Student student : userRepository.findAllStudentByCourse(courseCode, institutionCode)) {
			courses.add(student);
		}
		return courses;
	}
	
	public Collection<Student> findAllStudentsByInstitution(final String institutionCode) {
		return studentRepository.findAllStudentByInstitutionCode(institutionCode);
	}
	
	
	//===== Dependence Inject =====//
	@Autowired
	@Qualifier("institutionRepository")
	public void setInstitutionRepository(final InstitutionRepository repository) {
		institutionRepository = repository;
	}
	
	@Autowired
	@Qualifier("courseRepository")
	public void setCourseRepository(final CourseRepository repository) {
		courseRepository = repository;
	}
	
	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository(final UserRepository repository) {
		userRepository = repository;
	}
	
	@Autowired
	@Qualifier("studentRepository")
	public void setStudentRepository(final StudentRepository repository) {
		studentRepository = repository;
	}

}