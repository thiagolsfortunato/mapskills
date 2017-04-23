/*
 * @(#)CourseListWrapper.java 1.0 14/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.restapi.serializer.CourseListSerializer;
/**
 * 
 * A classe {@link CourseListWrapper} contem uma lista de cursos
 * que sera serializado pela classe <code>CourseListSerializer/code>.
 *
 * @author Marcelo
 * @version 1.0 22/04/2017
 */
@JsonSerialize(using = CourseListSerializer.class)
public class CourseListWrapper {
	
	private final Collection<Course> courses = new ArrayList<>();
	
	public CourseListWrapper(final Collection<Course> courses) {
		this.courses.clear();
		this.courses.addAll(courses);
	}
	
	public Collection<Course> getCourses() {
		return Collections.unmodifiableCollection(courses);
	}

}
