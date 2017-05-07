/*
 * @(#)CourseDeserializer.java 1.0 15/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.restapi.wrapper.CourseWrapper;
/**
 * 
 * A classe {@link CourseDeserializer} é responsavel
 * por deserializar um <i>POST</i> de um curso para
 * que seja cadastrado ou atualizado.
 *
 * @author Marcelo
 * @version 1.0 15/01/2017
 */
public class CourseDeserializer extends DefaultJsonDeserializer<CourseWrapper> {

	@Override
	protected CourseWrapper deserialize(final JsonNode node) {
		return new CourseWrapper(Course.builder()
				.id(jsonUtil.getFieldLongValue(node, "id"))
				.code(jsonUtil.getFieldTextValue(node, "code"))
				.name(jsonUtil.getFieldTextValue(node, "name"))
				.period(CoursePeriod.valueOf(jsonUtil.getFieldTextValue(node, "period")))
				.institutionCode(jsonUtil.getFieldTextValue(node, "institutionCode"))
				.build());
	}

}
