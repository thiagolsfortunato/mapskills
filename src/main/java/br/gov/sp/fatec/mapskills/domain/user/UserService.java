/*
 * @(#)UserService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Component
public class UserService implements RepositoryService<User> {
	
	@Autowired(required = true)
	@Qualifier("userRepository")
	private UserRepository repository;

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}
	
	public void save(final Administrator admin) {
		repository.save(admin);
	}

	public User findUserByUsernamePassword(final String username, final String password) throws MapSkillsException {
		final User user = repository.findByLogin(new Login(username, password));
		if (user == null) {
			throw new UserNotFoundException(username);
		}
		return user;
	}


}
