/*
 * @(#)UserSerializer.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.restapi.wrapper.UserWrapper;
import br.gov.sp.fatec.mapskills.utils.BeanRetriever;

public class UserSerializer extends JsonSerializer<UserWrapper> {
	
	private final Map<ProfileType, UserSerilizerStrategy> mapSerializer = new EnumMap<>(ProfileType.class);
	
	@SuppressWarnings("unchecked")
	public UserSerializer() {
		super();
		mapSerializer.putAll(BeanRetriever.getBean("mapSerializerStrategy", Map.class));
	}

	@Override
	public void serialize(final UserWrapper userWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		
		final UserSerilizerStrategy serializer = mapSerializer.get(userWrapper.getProfile());
		serializer.serialize(userWrapper.getUser(), generator);
		
	}

}
