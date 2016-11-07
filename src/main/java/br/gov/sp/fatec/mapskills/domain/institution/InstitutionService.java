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
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.UserRepository;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Service
public class InstitutionService implements RepositoryService<Institution> {
	
	@Autowired
	private InstitutionRepository institutionRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void saveInstitution(final Institution institution) {
		institutionRepository.save(institution);
	}
	
	public void saveInstitutions(final List<Institution> institutions) {
		institutionRepository.save(institutions);
	}
	
	public void update(final Institution institution) {
		institutionRepository.save(institution);
	}

	public Institution findById(final int id) {
		return institutionRepository.findById(id);
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
	
	public Collection<Course> findAllCoursesByInstitution(final int id) {
		final List<Course> courses = new ArrayList<>();
		for(final Course course : courseRepository.findAllByInstitutionId(id)) {
			courses.add(course);
		}
		return courses;
	}
	
	public Collection<Student> findAllStudentsByCourse(final int courseCode, final int institutionCode) {
		final List<Student> courses = new ArrayList<>();
		for(final Student student : userRepository.findAllStudentByCourseCode(courseCode, institutionCode)) {
			courses.add(student);
		}
		return courses;
	}
	
	public void saveCourses(final List<Course> courses) {
		courseRepository.save(courses);
	}
	
}