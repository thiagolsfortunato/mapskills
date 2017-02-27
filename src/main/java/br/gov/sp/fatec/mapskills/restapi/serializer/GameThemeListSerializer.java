/*
 * @(#)GameThemeListSerializer.java 1.0 24/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeListWrapper;
/**
 * A classe <code>GameThemeListSerializer<code> serializa uma lista de objetos
 * GameTheme, devolvendo todos temas criados pelo perfil administrador
 * @author Marcelo
 *
 */
public class GameThemeListSerializer extends JsonSerializer<GameThemeListWrapper> {

	@Override
	public void serialize(final GameThemeListWrapper gameThemes, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {

		generator.writeStartArray();
		for(final GameTheme theme : gameThemes.getGameThemes()) {
			generator.writeStartObject();
			generator.writeNumberField("id", theme.getId());
			generator.writeStringField("description", theme.getName());
			generator.writeBooleanField("active", theme.isActive());
			generator.writeEndObject();
		}
		generator.writeEndArray();
		
	}

}
