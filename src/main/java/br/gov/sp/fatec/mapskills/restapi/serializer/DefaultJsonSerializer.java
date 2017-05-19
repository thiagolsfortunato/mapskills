/*
 * @(#)DefaultJsonSerializer<T>.java 1.0 07/05/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * 
 * A classe {@link DefaultJsonSerializer} define metodos
 * em comum entre todos serializers da aplicacao.
 *
 * @author Marcelo
 * @version 1.0 07/05/2017
 */
public abstract class DefaultJsonSerializer<T> extends JsonSerializer<T> {
	
	protected static final String PASS = "password";
	protected static final String EMPTY_PASS = "";
	
	protected abstract void serialize(final T wrapper, final JsonGenerator generator) throws IOException;

	@Override
	public void serialize(final T wrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		this.serialize(wrapper, generator);

	}

}
