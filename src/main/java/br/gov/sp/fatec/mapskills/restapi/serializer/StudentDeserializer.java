/*
 * @(#)StudentDeserializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentWrapper;

public class StudentDeserializer extends JsonDeserializer<StudentWrapper> {

	@Override
	public StudentWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final String ra = node.get("ra").asText();
        final String institutionCode = ra.substring(0, 3);
        final String courseCode = ra.substring(3, 6);
        
        final AcademicRegistry registry = new AcademicRegistry(ra, institutionCode, courseCode);
        
        final Student student = new Student(registry, node.get("name").asText(), node.get("phone").asText(),
        		node.get("username").asText(), "Mudar@123");
        
		return new StudentWrapper(student);
	}

}
