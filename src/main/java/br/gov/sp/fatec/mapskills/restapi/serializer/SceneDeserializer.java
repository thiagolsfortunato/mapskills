/*
 * @(#)QuestionDeserializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneWrapper;

public class SceneDeserializer extends JsonDeserializer<SceneWrapper> {
	
	private static final String IP_SERVER = "http://localhost:8080/mapskills/";

	@Override
	public SceneWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {

		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final String fileImageBase64 = node.get("background").get("base64").asText();
        final String filename = node.get("background").get("filename").asText();
		
        final Question question = this.buildQuestion(node.get("question"));
        final long gameThemeId = node.get("gameThemeId").asLong();
        final Scene scene = new Scene(node.get("text").asText(), IP_SERVER + "images/" + filename, question, gameThemeId);
        
		return new SceneWrapper(scene, fileImageBase64, filename);
	}
	
	private Question buildQuestion(final JsonNode node) {
		if(node.isNull()) return null;
		final List<Alternative> alternatives = buildAlternatives(node.get("alternatives"));
		final Question question = new Question(alternatives, node.get("skillId").asLong());
		return question;
	}
	
	private List<Alternative> buildAlternatives(final JsonNode node) {
		final List<Alternative> alternatives = new ArrayList<>(4);
		for(int i = 0; i < 4; i++ ) {
			alternatives.add(new Alternative(node.get(i).get("description").asText(),
					node.get(i).get("skillValue").asInt()));
		}
		return alternatives;
	}

}
