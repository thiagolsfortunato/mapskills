/*
 * @(#)UserFactory.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;
/**
 * A interface <code>UserFactory</code> é uma abstração de cast de perfil.
 * @author Marcelo
 *
 */
public interface UserFactory {
	
	public <T extends User> T create(final User user);

}
