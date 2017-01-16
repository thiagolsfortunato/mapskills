/*
 * @(#)SkillDeserializer.java 1.0 01/11/2016
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

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SkillWrapper;

public class SkillDeserializer extends JsonDeserializer<SkillWrapper> {

	@Override
	public SkillWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final Skill skill = new Skill(node.get("type").asText(), node.get("description").asText());
        if(node.has("id")) skill.setId(node.get("id").asLong());
        
		return new SkillWrapper(skill);
	}

}
