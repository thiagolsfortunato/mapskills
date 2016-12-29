/*
 * @(#)SerializersConfig.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.restapi.serializer.UserSerilizerStrategy;
/**
 * A classe <code>SerializersConfig</code> possui um configuração de estrategia de serializaçao de perfil,
 * onde cada perfil possui seu serializador.
 * @author Marcelo
 *
 */
@Configuration
public class SerializersConfig {
	
	@Bean
	public Map<ProfileType, UserSerilizerStrategy> mapSerializerStrategy(@Autowired @Qualifier("defaultUserSerializer") final UserSerilizerStrategy defaultSerializer,
			@Autowired @Qualifier("studentSerializer") final UserSerilizerStrategy studentSerializer) {
		
		final Map<ProfileType, UserSerilizerStrategy> map = new EnumMap<>(ProfileType.class);
		map.put(ProfileType.ADMINISTRATOR, defaultSerializer);
		map.put(ProfileType.MENTOR, defaultSerializer);
		map.put(ProfileType.STUDENT, studentSerializer);
		
		return map;
	}

}
