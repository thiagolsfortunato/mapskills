/*
 * @(#)StudentListSerializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentListWrapper;
/**
 * 
 * A classe {@link StudentListSerializer} e responsavel
 * por serializar uma lista de alunos.
 *
 * @author Marcelo
 * @version 1.0 24/12/2016
 */
public class StudentListSerializer extends DefaultJsonSerializer<StudentListWrapper> {

	@Override
	public void serialize(final StudentListWrapper studentListWrapper, final JsonGenerator generator) throws IOException {
		
		generator.writeStartArray();
		for(final Student student : studentListWrapper.getStudents()) {
			generator.writeStartObject();
			this.studentSerialize(student, generator);
			this.courseSerialize(studentListWrapper.getCourse(student.getCourseCode()) , generator);
			generator.writeEndObject();
		}
		generator.writeEndArray();
		
	}
	
	private void studentSerialize(final Student student, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("id", student.getId());
		generator.writeStringField("name", student.getName());
		generator.writeStringField("ra", student.getRa());
		generator.writeStringField("phone", student.getPhone());
		generator.writeBooleanField("completed", student.isCompleted());
		generator.writeStringField("username", student.getUsername());
		generator.writeStringField(DefaultJsonSerializer.PASS, DefaultJsonSerializer.EMPTY_PASS);
	}
	/*
	 * TODO metodo duplicado, olhar comentario na classe {@link CourseListSerializer}.
	 */
	private void courseSerialize(final Course course, final JsonGenerator generator) throws IOException {
		generator.writeObjectFieldStart("course");
		generator.writeStringField("code", course.getCode());
		generator.writeStringField("name", course.getName());
		generator.writeStringField("period", course.getPeriod());
		generator.writeEndObject();
	}
	
	

}
