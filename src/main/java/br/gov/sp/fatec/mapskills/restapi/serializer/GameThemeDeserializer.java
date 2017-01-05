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
		
		return new GameThemeWrapper(theme);
	}

}
