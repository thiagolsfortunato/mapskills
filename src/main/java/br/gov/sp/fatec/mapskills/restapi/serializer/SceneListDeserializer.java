/*
 * @(#)SceneListDeserializer.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneListWrapper;

public class SceneListDeserializer extends JsonDeserializer<SceneListWrapper> {

	@Override
	public SceneListWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final Collection<Scene> scenes = new ArrayList<>();
        final int sizeArray = node.size();
        for(int i = 0; i < sizeArray; i++) {
        	final JsonNode nodeCurrent = node.get(i);
        	scenes.add(new Scene(nodeCurrent.get("text").asText(), nodeCurrent.get("background").get("filename").asText(),
        			this.buildQuestion(nodeCurrent.get("question")), nodeCurrent.get("gameThemeId").asLong()));
        }

        
		return new SceneListWrapper(scenes);
	}
	
	private Question buildQuestion(final JsonNode node) {
		if(node.isNull()) {
			return null;
		}
		final Question question = new Question(buildAlternatives(node.get("alternatives")), node.get("skillId").asLong());
		question.setId(node.get("id").asLong());
		return question;
	}
	
	private Collection<Alternative> buildAlternatives(final JsonNode node) {
		final Collection<Alternative> alternatives = new ArrayList<>(4);
		for(int i = 0; i < 4; i++) {
			final Alternative alternative = new Alternative(node.get(i).get("description").asText(), node.get(i).get("skillValue").asInt());
			alternative.setId(node.get(i).get("id").asLong());
			alternatives.add(alternative);
		}
		return alternatives;
	}

}
