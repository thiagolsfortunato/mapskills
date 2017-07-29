/*
 * @(#)InstitutionService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.mentor.MentorRepository;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.domain.user.student.StudentInvalidException;
import br.gov.sp.fatec.mapskills.domain.user.student.StudentRepository;
import br.gov.sp.fatec.mapskills.infrastructure.InstitutionExcelFileHandle;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;
import br.gov.sp.fatec.mapskills.infrastructure.StudentExcelFileHandle;
import lombok.AllArgsConstructor;

/**
 * 
 * A classe {@link InstitutionService} contem todos metodos necessarios
 * para realizacao de tudo que esta relacionado ha instituicao.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
@Service
@AllArgsConstructor
public class InstitutionService implements RepositoryService {
	
	private static final Logger LOGGER = Logger.getLogger(InstitutionService.class.getName());
		
	private final InstitutionRepository institutionRepository;
	private final CourseRepository courseRepository;
	private final StudentRepository studentRepository;
	private final MentorRepository mentorRepository;
	private final StudentExcelFileHandle studentExcelHandle;
	private final InstitutionExcelFileHandle institutionExcelFileHandle;
	
	@Override
	public void deleteAll() {
		mentorRepository.deleteAll();
		studentRepository.deleteAll();
		courseRepository.deleteAll();
		institutionRepository.deleteAll();
	}
	
	public List<Institution> saveInstituionFromExcel(final InputStream inputStream) throws MapSkillsException {
		final List<Institution> institutionsFromExcel = institutionExcelFileHandle.toObjectList(inputStream);
		return saveInstitutions(institutionsFromExcel);
	}
	
	public List<Student> saveStudentsFromExcel(final InputStream inputStream) throws MapSkillsException {
		final List<Student> studentsFromExcel = studentExcelHandle.toObjectList(inputStream);
		return saveStudents(studentsFromExcel);
	}

	@Transactional
	public List<Institution> saveInstitutions(final List<Institution> institutions) {
		final List<Institution> institutionsSaved = new ArrayList<>(institutions.size());
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
			final Student existingStudent = studentRepository.findByRaOrUsername(student.getRa(), student.getUsername()); 
			if(existingStudent == null) {
				studentsSaved.add(this.saveStudent(student));
				continue;
			}
			existingStudent.update(student);
			studentsSaved.add(this.saveStudent(existingStudent));
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
	public List<Course> findAllCoursesByInstitutionCode(final String institutionCode) {
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
	
	public List<Student> findAllStudentsByInstitution(final String institutionCode) {
		return studentRepository.findAllByRaInstitutionCode(institutionCode);
	}
	
	@Transactional(readOnly = true)
	public long findThemeCurrent(final String institutionCode) {
		return institutionRepository.findGameThemeIdByCode(institutionCode);
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getStudentsProgressByInstitution(final String institutionCode) {
		final String yearSemester = getYearSemesterCurrent();
		return institutionRepository.findStudentsProgressByInstitution(institutionCode, yearSemester);
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getGlobalPogress() {
		final String yearSemester = getYearSemesterCurrent();
		return institutionRepository.findGlobalStudentsProgress(yearSemester);
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getLevelPogress(final String level) {
		final String yearSemester = getYearSemesterCurrent();
		return institutionRepository.findLevelStudentsProgress(level, yearSemester);
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

}