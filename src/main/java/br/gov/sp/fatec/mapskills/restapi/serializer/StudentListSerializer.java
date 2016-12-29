/*
 * @(#)StudentListSerializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentListWrapper;

public class StudentListSerializer extends JsonSerializer<StudentListWrapper> {

	@Override
	public void serialize(StudentListWrapper studentListWrapper, JsonGenerator generator, SerializerProvider arg2)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
