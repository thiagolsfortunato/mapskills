/* @(#)GameThemeDeserializer.java 1.0 08/01/2017
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

import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeWrapper;

public class GameThemeDeserializer extends JsonDeserializer<GameThemeWrapper> {

	@Override
	public GameThemeWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final GameTheme theme = new GameTheme(node.get("description").asText());
        
        if(node.has("id")) {
        	theme.setId(node.get("id").asLong());
        }
        if(node.has("active") && isActiveNode(node)) {
        	theme.enable();
        }
		
		return new GameThemeWrapper(theme);
	}
	
	private boolean isActiveNode (final JsonNode node) {
		return node.get("active").asBoolean();
	}

}
