/*
 * @(#)InstitutionService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 * 
 * A classe {@link InstitutionService} contem todos metodos necessarios
 * para realizacao de tudo que esta relacionado ha instituicao.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
@Service
public class InstitutionService implements RepositoryService {
	
	private static final Logger LOGGER = Logger.getLogger(InstitutionService.class.getName());
		
	private InstitutionRepository institutionRepository;
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;
	private MentorRepository mentorRepository;
	
	@Override
	public void deleteAll() {
		mentorRepository.deleteAll();
		studentRepository.deleteAll();
		courseRepository.deleteAll();
		institutionRepository.deleteAll();
	}

	@Transactional
	public Collection<Institution> saveInstitutions(final Collection<Institution> institutions) {
		final Collection<Institution> institutionsSaved = new ArrayList<>(institutions.size());
		for(final Institution institution : institutions) {
			institutionsSaved.add(this.saveInstitution(institution));
		}
		return institutionsSaved;
	}
	
	public void saveMentor(final Mentor mentor) {
		mentorRepository.save(mentor);
	}
	
	public void saveMentors(final Collection<Mentor> mentors, final long institutionId) {
		for(final Mentor mentor : mentors) {
			mentor.setInstitutionId(institutionId);
			this.saveMentor(mentor);
		}
	}

	@Transactional
	public Institution saveInstitution(final Institution institution) {
		institutionRepository.save(institution);
		this.saveMentors(institution.getMentors(), institution.getId());
		return institution;			
	}
	
	public void saveCourses(final Collection<Course> courses) {
		for(final Course course : courses) {
			this.saveCourse(course);			
		}
	}
	
	public Course saveCourse(final Course course) {
		return courseRepository.save(course);
	}
	
	@Transactional
	public List<Student> saveStudents(final Collection<Student> students) throws MapSkillsException {
		final List<Student> studentsSaved = new ArrayList<>(students.size());
		for(final Student student : students) {
			if(studentRepository.findByRaRa(student.getRa()) == null) {
				studentsSaved.add(this.saveStudent(student));
			}
		}
		return Collections.unmodifiableList(studentsSaved);
	}
	
	public Student saveStudent(final Student student) throws MapSkillsException {
		try {
			return studentRepository.save(student);
		} catch (final Exception exc) {
			LOGGER.log(Level.INFO, exc.getMessage(), exc);
			throw new StudentInvalidException();
		}
	}
	
	public Student updateStudent(final long id, final Student student) throws MapSkillsException {
		final Student studentBase = studentRepository.findOne(id);
		studentBase.update(student);
		return saveStudent(studentBase);
	}

	public Institution findInstitutionById(final long id) {
		return institutionRepository.findById(id);
	}
	
	public Institution findInstitutionByCnpj(final String cnpj) {
		return institutionRepository.findByCnpj(cnpj);
	}
	
	public Mentor findMentorByUsername(final String username) {
		return mentorRepository.findByLoginUsername(username);
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
	 * Metodo que recupera todos os cursos de uma determinada instituicao
	 */
	public Collection<Course> findAllCoursesByInstitutionCode(final String institutionCode) {
		final List<Course> courses = new ArrayList<>();
		for(final Course course : courseRepository.findAllByInstitutionCode(institutionCode)) {
			courses.add(course);
		}
		return courses;
	}
	/**
	 * Metodo que recupera todos alunos de um curso de uma determinada instituicao
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
	
	public List<Object[]> getStudentsProgressByInstitution(final String institutionCode) {
		final String yearSemester = getYearSemesterCurrent();
		return institutionRepository.getStudentsProgressByInstitution(institutionCode, yearSemester);
	}
	
	public List<Object[]> getGlobalPogress() {
		final String yearSemester = getYearSemesterCurrent();
		return institutionRepository.getGlobalStudentsProgress(yearSemester);
	}
	
	public List<Object[]> getLevelPogress(final String level) {
		final String yearSemester = getYearSemesterCurrent();
		return institutionRepository.getLevelStudentsProgress(level, yearSemester);
	}
	/**
	 * Metodo que recupera o ano e semestre corrente.
	 */
	private String getYearSemesterCurrent() {
		final LocalDate dateCurrent = LocalDate.now();
		final String semester = dateCurrent.getMonthValue() < 6 ? "1" : "2";
		final String year = String.valueOf(dateCurrent.getYear());
		return year.substring(2).concat(semester);
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