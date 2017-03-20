/*
 * @(#)StudentsProgressGlobalSerializer.java 1.0 01/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.restapi.wrapper.report.StudentsProgressGlobalWrapper;

public class StudentsProgressGlobalSerializer extends JsonSerializer<StudentsProgressGlobalWrapper> {

	@Override
	public void serialize(final StudentsProgressGlobalWrapper progess, final JsonGenerator generator,
			final SerializerProvider arg2) throws IOException {
		
		generator.writeStartArray();
		
		for(final Object[] tuple : progess.getResultSet() ) {
			generator.writeStartObject();
			
			final InstitutionLevel level = InstitutionLevel.valueOf(String.valueOf(tuple[1]));
			generator.writeStringField("level", level.isSuperior() ? "Fatecs" : "Etecs" );
			
			generator.writeArrayFieldStart("values");
			generator.writeNumber(Integer.valueOf(tuple[3] != null ? tuple[3].toString() : "0"));
			generator.writeNumber(Integer.valueOf(tuple[2] != null ? tuple[2].toString() : "0"));
			generator.writeEndArray();
			
			generator.writeEndObject();
		}
		
		generator.writeEndArray();
		
	}

}
