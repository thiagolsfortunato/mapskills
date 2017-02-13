/*
 * @(#)StudentDetailsSerializer.java 1.0 11/02/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentDetailsWrapper;
/**
 * A classe <code>StudentDetailsSerializer</code> representa o aluno em
 * detalhes para que possa ser serializado pela aplicacao.
 * 
 * @author Marcelo
 *
 */
public class StudentDetailsSerializer extends JsonSerializer<StudentDetailsWrapper> {

	@Override
	public void serialize(final StudentDetailsWrapper studentWrapper, final JsonGenerator generator,
			final SerializerProvider arg2)	throws IOException {
		
		generator.writeStartObject();
		this.studentSerialize(studentWrapper.getStudent(), generator);
		this.courseSerialize(studentWrapper.getCourse(), generator);
		this.institutionSerialize(studentWrapper.getInstitution(), generator);
		generator.writeEndObject();
		
	}
	
	private void studentSerialize(final Student student, final JsonGenerator generator) throws IOException {
		generator.writeObjectFieldStart("student");
		generator.writeStringField("name", student.getName());
		generator.writeStringField("ra", student.getRa());
		generator.writeStringField("phone", student.getPhone());
		generator.writeStringField("username", student.getUsername());
		generator.writeStringField("password", "");
		generator.writeEndObject();
	}
	
	private void courseSerialize(final Course course, final JsonGenerator generator) throws IOException {
		generator.writeObjectFieldStart("course");
		generator.writeStringField("code", course.getCode());
		generator.writeStringField("name", course.getName());
		generator.writeStringField("period", course.getPeriod());
		generator.writeEndObject();
	}
	
	private void institutionSerialize(final Institution institution, final JsonGenerator generator) throws IOException {
		generator.writeObjectFieldStart("institution");
		generator.writeStringField("code", institution.getCode());
		generator.writeStringField("company", institution.getCompany());
		generator.writeStringField("cnpj", institution.getCnpj());
		generator.writeStringField("city", institution.getCity());
		generator.writeEndObject();
	}

}
