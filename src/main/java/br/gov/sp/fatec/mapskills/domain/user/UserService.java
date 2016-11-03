/*
 * @(#)UserService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Component
public class UserService implements RepositoryService<User> {
	
	@Autowired(required = true)
	@Qualifier("userRepository")
	private UserRepository repository;

	public void create(final Student obj) {
		repository.save(obj);
	}
	
	public void create(final List<Student> obj) {
		repository.save(obj);
	}

	@Override
	public User findById(final Integer id) {
		return repository.findById(id);
	}

}
