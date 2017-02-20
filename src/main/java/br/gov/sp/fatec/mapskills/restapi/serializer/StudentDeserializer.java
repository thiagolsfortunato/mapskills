/*
 * @(#)StudentDeserializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.user.student.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentWrapper;

public class StudentDeserializer extends JsonDeserializer<StudentWrapper> {
	
	protected static final String ENCRYPTED_DEFAULT_PASSWORD = "$2a$10$TH9WvYSs4BYDi7NaesV.Uerv7ZyzXXrEuriWeo2qAl96i6fN3oz8G";
	
	@Autowired
	private PasswordEncoder encoder;

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
        		node.get("username").asText(), null);
        if(node.has("password") && !StringUtils.isEmpty(node.get("password").asText())) {
        	student.setPassword(encoder.encode(node.get("password").asText()));
        } else {
        	student.setPassword(ENCRYPTED_DEFAULT_PASSWORD);
        }
        if(node.has("id")) {
        	student.setId(node.get("id").asLong());
        }
        
		return new StudentWrapper(student);
	}

}
