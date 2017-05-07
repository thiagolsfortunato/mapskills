/*
 * @(#)StudentDetailsWrapper.java 1.0 11/02/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.restapi.serializer.StudentDetailsSerializer;

/**
 * 
 * A classe {@link StudentDetailsWrapper} encapsula um <code>Student</code> (aluno),
 * e seu <code>Course</code> (curso) e a <code>Institution</code> (instituicao) a qual
 * pertence para que seja serializado.
 *
 * @author Marcelo
 * @version 1.0 11/02/2017
 */
@JsonSerialize(using = StudentDetailsSerializer.class)
public class StudentDetailsWrapper {
	
	private final Student student;
	private final Course course;
	private final Institution institution;
	
	public StudentDetailsWrapper(final Student student, final Course course, final Institution institution) {
		this.student = student;
		this.course = course;
		this.institution = institution;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public Institution getInstitution() {
		return institution;
	}

}
