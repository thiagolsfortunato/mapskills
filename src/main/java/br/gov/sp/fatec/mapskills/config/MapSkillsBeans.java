/*
 * @(#)MapSkillsBeans.java 1.0 10/11/2016
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
import br.gov.sp.fatec.mapskills.domain.user.UserFactory;

@Configuration
public class MapSkillsBeans {
	
	@Bean
	public Map<ProfileType, UserFactory> userFactory(@Autowired @Qualifier("administratorFactory") final UserFactory administrator,
			@Autowired @Qualifier("mentorFactory") final UserFactory mentor,
			@Autowired @Qualifier("studentFactory") final UserFactory student) {
		
		final Map<ProfileType, UserFactory> users = new EnumMap<>(ProfileType.class);
		users.put(ProfileType.ADMINISTRATOR, administrator);
		users.put(ProfileType.MENTOR, mentor);
		users.put(ProfileType.STUDENT, student);
		
		return users;
	}

}
