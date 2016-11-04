package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeWrapper;

public class GameThemeDeserializer extends JsonDeserializer<GameThemeWrapper> {

	@Override
	public GameThemeWrapper deserialize(final JsonParser arg0, final DeserializationContext arg1)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
