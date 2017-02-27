/* @(#)InstitutionDeserializer.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionDetailsWrapper;

public class InstitutionDeserializer extends JsonDeserializer<InstitutionDetailsWrapper> {
	
	private final static String MENTOR = "mentor";

	@Override
	public InstitutionDetailsWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);

        final Collection<Mentor> mentors = new LinkedList<>();
        
        if(node.has(MENTOR)) {
        	mentors.add(this.mentorDeserialeze(node.get(MENTOR)));
        } else {
        	mentors.addAll(this.mentorListDeserialize(node.get("mentors")));
        }
        
		final Institution institution =  new Institution(node.get("code").asText(), node.get("cnpj").asText(),
				node.get("company").asText(), InstitutionLevel.valueOf(node.get("level").asText()), node.get("city").asText(), mentors);
 
        if(node.has("id")) {
        	institution.setId(node.get("id").asLong());
        }
		
		return new InstitutionDetailsWrapper(institution);
	}
	
	private Mentor mentorDeserialeze(final JsonNode node) {
		final Mentor mentor = new Mentor(node.get("name").asText(), node.get("institutionCode").asText(), node.get("username").asText(),
				node.get("password").asText());

        if(node.has("id")) {
        	mentor.setId(node.get("id").asLong());
        }
        return mentor;
	}
	
	private Collection<Mentor> mentorListDeserialize(final JsonNode node) {
		final int sizeArray = node.size();
		final Collection<Mentor> mentors = new LinkedList<>();
		for(int i = 0; i < sizeArray; i++ ) {
			final JsonNode nodeCurrent = node.get(i);
			mentors.add(new Mentor(nodeCurrent.get("name").asText(), nodeCurrent.get("institutionCode").asText(),
					nodeCurrent.get("username").asText(), nodeCurrent.get("password").asText()));
		}
		return mentors;
	}

}
