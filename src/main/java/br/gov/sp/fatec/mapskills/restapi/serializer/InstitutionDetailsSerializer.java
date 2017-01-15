/*
 * @(#)InstitutionDetailsSerializer.java 1.0 07/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionDetailsWrapper;
import br.gov.sp.fatec.mapskills.utils.BeanRetriever;

public class InstitutionDetailsSerializer extends JsonSerializer<InstitutionDetailsWrapper> {
	
	private final DefaultInstitutionSerializer defaultSerializer;
	
	public InstitutionDetailsSerializer() {
		this.defaultSerializer = BeanRetriever.getBean("defaultInstitutionSerializer", DefaultInstitutionSerializer.class);
	}
	
	@Override
	public void serialize(final InstitutionDetailsWrapper detailsWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {

		final Institution institution = detailsWrapper.getInstitution();
		generator.writeStartObject();
		defaultSerializer.serializeDefaultValues(institution, generator);
		generator.writeArrayFieldStart("courses");
		for(final Course course : institution.getCourses()) {
			generator.writeStartObject();
			this.courseSerializer(course, generator);
			generator.writeEndObject();
		}
		generator.writeEndArray();
		generator.writeObjectFieldStart("mentor");
		this.mentorSerializer(institution.getMentor(), generator);
		generator.writeEndObject();
		generator.writeEndObject();
		
	}
	
	private void courseSerializer(final Course course, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("id", course.getId());
		generator.writeStringField("code", course.getCode());
		generator.writeStringField("name", course.getName());
		generator.writeStringField("period", course.getPeriod());
	}
	
	private void mentorSerializer(final Mentor mentor, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("id", mentor.getId());
		generator.writeStringField("name", mentor.getName());
		generator.writeStringField("username", mentor.getUsername());
		generator.writeStringField("password", mentor.getPassword());
	}

}
