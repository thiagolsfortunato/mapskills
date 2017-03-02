/*
 * @(#)StudentsProgressLevelSerializer.java 1.0 01/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentsProgressLevelWrapper;

public class StudentsProgressLevelSerializer extends JsonSerializer<StudentsProgressLevelWrapper> {

	@Override
	public void serialize(final StudentsProgressLevelWrapper progress, final JsonGenerator generator,
			final SerializerProvider arg2) throws IOException {

		generator.writeStartArray();
		
		for(final Object[] tuple : progress.getResultSet()) {
			generator.writeStartObject();
			
			generator.writeStringField("institution", String.valueOf(tuple[3]));
			
			generator.writeStartArray();
			generator.writeNumber(Integer.valueOf(tuple[5] != null ? tuple[5].toString() : "0"));
			generator.writeNumber(Integer.valueOf(tuple[4] != null ? tuple[4].toString() : "0"));
			generator.writeEndArray();
			
			generator.writeEndObject();
		}
		
		generator.writeEndArray();
		
	}

}
