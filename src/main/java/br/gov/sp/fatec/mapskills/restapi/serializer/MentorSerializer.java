/*
 * @(#)MentorSerializer.java 1.0 31/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.User;

@Component
public class MentorSerializer extends DefaultUserSerializer {
	
	@Override
	public void serialize(final User user, final JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		serializeDefaultValues(user, generator);
		final Mentor mentor = (Mentor) user;
		generator.writeStringField("institutionCode", mentor.getInstitutionCode());
		generator.writeEndObject();
		
	}

}
