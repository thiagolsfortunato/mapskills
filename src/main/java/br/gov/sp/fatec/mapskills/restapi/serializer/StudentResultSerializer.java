/* @(#)StudentResultSerializer.java 1.0 04/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentResultWrapper;

public class StudentResultSerializer extends JsonSerializer<StudentResultWrapper> {

	@Override
	public void serialize(StudentResultWrapper result, JsonGenerator generator, SerializerProvider arg2)
			throws IOException {

		generator.writeStartObject();
		generator.writeArrayFieldStart("labels");
		for(final String skill : result.getSkills()) {
			generator.writeString(skill);
		}
		generator.writeEndArray();
		generator.writeArrayFieldStart("datasets");
		for(final long value : result.getValues()) {
			generator.writeNumber(value);
		}
		generator.writeEndArray();
		generator.writeEndObject();
	}

}
