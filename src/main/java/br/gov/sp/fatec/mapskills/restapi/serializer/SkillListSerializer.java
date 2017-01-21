/*
 * @(#)SkillSerializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SkillListWrapper;
/**
 * A classe <code>SkillListSerializer</code> serializa uma array
 * de competencias.
 * @author Marcelo
 *
 */
public class SkillListSerializer extends JsonSerializer<SkillListWrapper> {

	@Override
	public void serialize(final SkillListWrapper skillList, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		generator.writeStartArray();
		for(final Skill skill : skillList.getAllSkills()) {
			generator.writeStartObject();
			generator.writeNumberField("id", skill.getId());
			generator.writeStringField("type", skill.getType());
			generator.writeStringField("description", skill.getDescription());
			generator.writeEndObject();
		}
		generator.writeEndArray();
		
	}

}
