package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeListWrapper;

public class GameThemeListDeserializer extends JsonDeserializer<GameThemeListWrapper> {

	@Override
	public GameThemeListWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final Collection<GameTheme> gameThemes = new ArrayList<>();
        final int sizeArray = node.size();
        for(int i = 0; i < sizeArray; i++) {
        	final JsonNode nodeCurrent = node.get(i);
        	final GameTheme theme = new GameTheme(nodeCurrent.get("description").asText());
        	theme.setId(nodeCurrent.get("id").asLong());
        	if(nodeCurrent.get("active").asBoolean()) {
        		theme.enable();
        	}
        	gameThemes.add(theme);
        }
        
		return new GameThemeListWrapper(gameThemes);
	}

}
