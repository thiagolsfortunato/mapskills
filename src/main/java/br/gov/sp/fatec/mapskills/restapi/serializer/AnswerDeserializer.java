/* @(#)AnswerDeserializer.java 1.0 13/01/2017
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

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;
import br.gov.sp.fatec.mapskills.restapi.wrapper.AnswerWrapper;

public class AnswerDeserializer extends JsonDeserializer<AnswerWrapper> {

	@Override
	public AnswerWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
        final AnswerEvent answerEvent = new AnswerEvent(node.get("sceneIndex").asInt(), node.get("sceneId").asLong()
        		, node.get("studentId").asLong(), node.get("skillId").asLong(), node.get("skillValue").asInt());
		
		return new AnswerWrapper(answerEvent);
	}

}
