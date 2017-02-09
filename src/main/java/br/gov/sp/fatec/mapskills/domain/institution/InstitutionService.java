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

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.StudentRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;
/**
 * A classe <code>InstitutionService</code> contem todos metodos necessários para realizacao
 * de tudo que esta relacionado ha instituicao.
 * @author Marcelo
 *
 */
@Service
public class InstitutionService implements RepositoryService {
		
	private InstitutionRepository institutionRepository;
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;
	
	@Override
	public void deleteAll() {
		institutionRepository.deleteAll();
		courseRepository.deleteAll();
		studentRepository.deleteAll();
	}

	public void saveInstitutions(final Collection<Institution> institutions) {
		institutionRepository.save(institutions);
	}

	public Institution saveInstitution(final Institution institution) {
		return institutionRepository.save(institution);
	}
	
	public void saveCourses(final Collection<Course> courses) {
		courseRepository.save(courses);
	}
	
	public void saveCourse(final Course course) {
		courseRepository.save(course);
	}
	
	public void saveStudents(final Collection<Student> students) {
		studentRepository.save(students);
	}
	
	public void saveStudent(final Student student) {
		studentRepository.save(student);
	}

	public Institution findInstitutionById(final long id) {
		return institutionRepository.findById(id);
	}
	
	public Institution findInstitutionByCode(final String code) {
		return institutionRepository.findByCode(code);
	}
	
	public Student findStudentByRa(final String ra) {
		return studentRepository.findByRaRa(ra);
	}
	
	public Collection<Institution> findAllInstitutions() {
		final List<Institution> institutions = new ArrayList<>();
		for(final Institution institution : institutionRepository.findAll()) {
			institutions.add(institution);
		}
		return institutions;
	}
	
	public Institution findInstitutionDetailsById(final long id) throws MapSkillsException {
		final Institution institution = institutionRepository.findById(id);
		if(institution == null) {
			throw new InstitutionNotFoundException(id);
		}
		institution.setCourses(courseRepository.findAllByInstitutionCode(institution.getCode()));
		return institution;
	}
	
	/**
	 * Método que recupera todos os cursos de uma determinada instituição
	 * @param code
	 * @return
	 */
	public Collection<Course> findAllCoursesByInstitutionCode(final String institutionCode) {
		final List<Course> courses = new ArrayList<>();
		for(final Course course : courseRepository.findAllByInstitutionCode(institutionCode)) {
			courses.add(course);
		}
		return courses;
	}
	/**
	 * Método que recupera todos alunos de um curso de uma determinada instituição
	 * @param courseCode
	 * @param institutionCode
	 * @return
	 */
	public Collection<Student> findAllStudentsByCourseAndInstitution(final String courseCode, final String institutionCode) {
		final List<Student> courses = new ArrayList<>();
		for(final Student student : studentRepository.findAllByCourseAndInstitution(courseCode, institutionCode)) {
			courses.add(student);
		}
		return courses;
	}
	
	public Collection<Student> findAllStudentsByInstitution(final String institutionCode) {
		return studentRepository.findAllByRaInstitutionCode(institutionCode);
	}
	
	public long findThemeCurrent(final String institutionCode) {
		return institutionRepository.findGameThemeIdByCode(institutionCode);
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
	@Qualifier("studentRepository")
	public void setStudentRepository(final StudentRepository repository) {
		studentRepository = repository;
	}


}