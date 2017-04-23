/*
 * @(#)StudentDeserializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.user.student.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentWrapper;
/**
 * 
 * A classe {@link StudentDeserializer} e responsavel
 * por deserializar um aluno para que seja cadastrado.
 *
 * @author Marcelo
 * @version 1.0 24/12/2016
 */
public class StudentDeserializer extends DefaultJsonDeserializer<StudentWrapper> {

	@Override
	protected StudentWrapper deserialize(final JsonNode node) {
		
		final String ra = jsonUtil.getFieldTextValue(node, "ra");
        final String institutionCode = ra.substring(0, 3);
        final String courseCode = ra.substring(3, 6);
        
        final AcademicRegistry registry = new AcademicRegistry(ra, institutionCode, courseCode);
        
        final Student student = Student.builder().ra(registry)
        		.name(jsonUtil.getFieldTextValue(node, "name"))
        		.phone(jsonUtil.getFieldTextValue(node, "phone"))
        		.username(jsonUtil.getFieldTextValue(node, "username"))
        		.password(jsonUtil.getFieldPasswordValue(node)).build();
        
		return new StudentWrapper(student);
	}

}
