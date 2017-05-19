/*
 * @(#)CourseListSerializer.java 1.0 14/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.restapi.wrapper.CourseListWrapper;
/**
 * 
 * A classe {@link CourseListSerializer} e responsavel
 * por serializar uma lista de cursos.
 *
 * @author Marcelo
 * @version 1.0 14/01/2017
 */
public class CourseListSerializer extends DefaultJsonSerializer<CourseListWrapper> {

	@Override
	public void serialize(final CourseListWrapper courseList, final JsonGenerator generator) throws IOException {
		
		generator.writeStartArray();
		for(final Course course : courseList.getCourses()) {
			generator.writeStartObject();
			this.courseSerialize(course, generator);
			generator.writeEndObject();
		}
		generator.writeEndArray();
		
	}
	
	private void courseSerialize(final Course course, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("id", course.getId());
		generator.writeStringField("code", course.getCode());
		generator.writeStringField("name", course.getName());
		generator.writeStringField("period", course.getPeriod());
		generator.writeStringField("institutionCode", course.getInstitutionCode());
	}

}
