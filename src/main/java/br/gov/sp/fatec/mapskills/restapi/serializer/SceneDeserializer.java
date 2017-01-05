/*
 * @(#)QuestionDeserializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.restapi.wrapper.Scene;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneWrapper;
import br.gov.sp.fatec.mapskills.utils.SaveImageService;

public class SceneDeserializer extends JsonDeserializer<SceneWrapper> {

	@Override
	public SceneWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException, JsonProcessingException {

		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final SaveImageService imageService = new SaveImageService(node.get("background").get("base64").asText());
        final String filename = node.get("background").get("filename").asText();
        final int filesize = node.get("background").get("filesize").asInt();
        final String urlPathImage = imageService.save(filename, filesize);
        
        final Scene scene = new Scene(node.get("text").asText(), urlPathImage);
        
		return new SceneWrapper(scene);
	}

}
