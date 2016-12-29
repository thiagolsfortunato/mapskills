/*
 * @(#)MentorFactory.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserFactory;

@Component
public class MentorFactory implements UserFactory {

	@Override
	public Mentor create(User user) {
		return (Mentor) user;
	}

}
