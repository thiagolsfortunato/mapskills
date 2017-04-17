/*
 * @(#)DefaultJsonDeserializer<T>.java 1.0 17/04/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.utils.JsonUtil;
/**
 * A classe <code>DefaultJsonDeserializer<T><code> implementa
 * padrão de projetos template method, onde os passos em comum
 * para deserialização de um objeto são executados, delegando
 * o resto do algoritmo para quem o implementará.
 * 
 * @author Marcelo
 *
 * @param <T>
 */
public abstract class DefaultJsonDeserializer<T> extends JsonDeserializer<T> {
	
	@Autowired
	protected JsonUtil jsonUtil;
	
	protected abstract T deserialize(final JsonNode node);

	@Override
	public T deserialize(final JsonParser jsonParser, final DeserializationContext arg1) throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
		return deserialize(node);
	}

}
