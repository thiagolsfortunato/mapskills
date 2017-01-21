/*
 * @(#)CourseDeserializer.java 1.0 15/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.restapi.wrapper.CourseWrapper;

public class CourseDeserializer extends JsonDeserializer<CourseWrapper> {

	@Override
	public CourseWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException	{
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final Course course = new Course(node.get("code").asText(), node.get("name").asText()
        		, CoursePeriod.valueOf(node.get("period").asText()), node.get("institutionCode").asText());
        
        if(node.has("id")) {
        	course.setId(node.get("id").asLong());
        }
        
		return new CourseWrapper(course);
	}

}
