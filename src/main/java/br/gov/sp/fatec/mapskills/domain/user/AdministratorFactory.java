/*
 * @(#)AdministratorFactory.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.stereotype.Component;

@Component
public class AdministratorFactory implements UserFactory {

	@Override
	public Administrator create(final User user) {
		return (Administrator) user;
	}

}
