/*
 * @(#)StudentListWrapper.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.restapi.serializer.StudentListSerializer;
/**
 * A classe <code>StudentListWrapper</code> cuida de serializar
 * uma lista de alunos em json.
 * @author Marcelo
 *
 */
@JsonSerialize(using = StudentListSerializer.class)
public class StudentListWrapper {
	
	private final Collection<Student> students = new ArrayList<>();
	private final Map<String, Course> coursesMap = new HashMap<>();
	
	public StudentListWrapper(final Collection<Student> students, final Collection<Course> courses) {
		this.students.addAll(students);
		for(final Course course : courses) {
			this.coursesMap.put(course.getCode(), course);
		}
	}
	
	public Collection<Student> getStudents() {
		return Collections.unmodifiableCollection(students);
	}
	
	public Course getCourse(final String courseCode) {
		return coursesMap.get(courseCode);
	}

}
