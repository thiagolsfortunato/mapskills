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
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.mentor.MentorRepository;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.domain.user.student.StudentInvalidException;
import br.gov.sp.fatec.mapskills.domain.user.student.StudentRepository;
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
	private MentorRepository mentorRepository;
	
	@Override
	public void deleteAll() {
		institutionRepository.deleteAll();
		courseRepository.deleteAll();
		studentRepository.deleteAll();
		mentorRepository.deleteAll();
	}

	@Transactional
	public void saveInstitutions(final Collection<Institution> institutions) {
		for(final Institution institution : institutions) {
			saveInstitution(institution);
		}
	}
	
	public void saveMentor(final Mentor mentor) {
		mentorRepository.save(mentor);
	}
	
	public void saveMentors(final Collection<Mentor> mentors) {
		for(final Mentor mentor : mentors) {
			this.saveMentor(mentor);			
		}
	}

	@Transactional
	public Institution saveInstitution(final Institution institution) {
		institutionRepository.save(institution);
		this.saveMentors(institution.getMentors());
		return institution;			
	}
	
	public void saveCourses(final Collection<Course> courses) {
		for(final Course course : courses) {
			this.saveCourse(course);			
		}
	}
	
	public void saveCourse(final Course course) {
		courseRepository.save(course);
	}
	
	public void saveStudents(final Collection<Student> students) throws MapSkillsException {
		for(final Student student : students) {
			if(studentRepository.findByRaRa(student.getRa()) == null) {
				this.saveStudent(student);
			}
		}
	}
	
	public void saveStudent(final Student student) throws MapSkillsException {
		try {
			studentRepository.save(student);
		} catch (final Exception exc) {
			throw new StudentInvalidException();
		}
	}

	public Institution findInstitutionById(final long id) {
		return institutionRepository.findById(id);
	}
	
	public Institution findInstitutionByCode(final String code) {
		final Institution institution = institutionRepository.findByCode(code);
		final Collection<Mentor> mentors = mentorRepository.findAllByInstitutionCode(code);
		institution.setMentors(mentors);
		return institution;
	}
	
	public Student findStudentByRa(final String ra) {
		return studentRepository.findByRaRa(ra);
	}
	
	public Student findStudentById(final long id) {
		return studentRepository.findOne(id);
	}
	
	public Course findCourseByCode(final String code) {
		return courseRepository.findByCode(code);
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
		institution.setMentors(mentorRepository.findAllByInstitutionCode(institution.getCode()));
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
	
	/* = = = = = Dependence Inject = = = = = **/
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
	
	@Autowired
	@Qualifier("mentorRepository")
	public void setMentorRepository(final MentorRepository repository) {
		mentorRepository = repository;
	}

}