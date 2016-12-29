/*
 * @(#)StudentDeserializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentWrapper;

public class StudentDeserializer extends JsonDeserializer<StudentWrapper> {

	@Override
	public StudentWrapper deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
