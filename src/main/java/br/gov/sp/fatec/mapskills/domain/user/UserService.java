/*
 * @(#)UserService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

@Component
public class UserService implements RepositoryService {
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
	
	@Autowired(required = true)
	@Qualifier("userRepository")
	private UserRepository repository;
	
	private PasswordEncoder encoder;

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	
	public void save(final Administrator admin) {
		repository.save(admin);
	}

	public User findUserByUsernamePassword(final String username, final String password) throws MapSkillsException {
		final User user = repository.findByUsername(username);
		if (user == null) {
			throw new UserNotFoundException(username);
		}
		return user;
	}
	
	public User findByUsername(final String username) {
		return repository.findByUsername(username);
	}
	
	/**
	 * valida o usuario, verificando se ele nao eh nulo ou possua as credenciais invalidas
	 * @param user
	 * @param password
	 * @return true em caso de sucesso
	 * 	e false em caso de falha
	 */
	public void authenticate(final User user, final String password) throws AuthenticationException {
		if(user == null || !encoder.matches(password, user.getPassword())) {
			LOGGER.warning("username/password invalid");
			throw new BadCredentialsException("username/password invalid");
		}
	}
	
	public void updatePassword(final String username, final String newPassword) {
		final User user = repository.findByUsername(username);
		user.setPassword(encoder.encode(newPassword));
		repository.save(user);
	}
	
	@Autowired
	public void setPasswordEncoder(final PasswordEncoder encoder) {
		this.encoder = encoder;
	}


}
