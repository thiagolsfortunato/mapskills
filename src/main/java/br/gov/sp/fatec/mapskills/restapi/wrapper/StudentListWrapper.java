/*
 * @(#)StudentListWrapper.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.restapi.serializer.StudentListSerializer;

@JsonSerialize(using = StudentListSerializer.class)
public class StudentListWrapper {
	
	private final Collection<Student> students = new ArrayList<>();
	
	public StudentListWrapper(final Collection<Student> students) {
		this.students.addAll(students);
	}
	
	public Collection<Student> geStudents() {
		return Collections.unmodifiableCollection(students);
	}

}
