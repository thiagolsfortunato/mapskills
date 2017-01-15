package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.restapi.serializer.CourseListSerializer;

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
