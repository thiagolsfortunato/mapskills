/*
 * @(#)StudentsProgressLevelSerializer.java 1.0 01/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.report.StudentsProgressLevelWrapper;

public class StudentsProgressLevelSerializer extends JsonSerializer<StudentsProgressLevelWrapper> {

	@Override
	public void serialize(final StudentsProgressLevelWrapper progress, final JsonGenerator generator,
			final SerializerProvider arg2) throws IOException {

		generator.writeStartObject();
		this.dataGenerate(progress.getResultSet(), generator);
		this.institutionGenerate(progress.getResultSet(), generator);
		generator.writeEndObject();
	}
	
	private void dataGenerate(final List<Object[]> resultSet, final JsonGenerator generator) throws IOException {		
		generator.writeArrayFieldStart("data");
		generator.writeStartArray();
		for(final Object[] tuple : resultSet) {
			final int totalStudents = Integer.valueOf(tuple[6].toString());
			generator.writeNumber(this.calcPercentage(Double.valueOf(tuple[4].toString()), totalStudents));
		}
		generator.writeEndArray();
		generator.writeStartArray();
		for(final Object[] tuple : resultSet) {
			final int totalStudents = Integer.valueOf(tuple[6].toString());
			generator.writeNumber(this.calcPercentage(Double.valueOf(tuple[5].toString()), totalStudents));
		}
		generator.writeEndArray();
		generator.writeEndArray();
	}
	
	private void institutionGenerate(final List<Object[]> resultSet, final JsonGenerator generator) throws IOException {
		generator.writeArrayFieldStart("institutions");
		for(final Object[] tuple : resultSet) {
			generator.writeStartObject();
			generator.writeStringField("code", tuple[1].toString());
			generator.writeStringField("company", tuple[3].toString());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
	
	private double calcPercentage(final double quantity, final double total) {
		return (quantity/total) * 100;
	}

}
