/*
 * @(#)DefaultUserSerializer.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.user.User;

@Component
public class DefaultUserSerializer implements UserSerilizerStrategy {
	
	protected void serializeDefaultValues(final User user, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("id", user.getId());
		generator.writeStringField("name", user.getName());
		generator.writeStringField("profile", user.getProfile().name());
	}

	@Override
	public void serialize(final User user, final JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		serializeDefaultValues(user, generator);
		generator.writeEndObject();
	}

}
