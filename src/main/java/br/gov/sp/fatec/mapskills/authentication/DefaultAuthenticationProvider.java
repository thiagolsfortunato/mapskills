/*
 * @(#)DefaultAuthenticationProvider.java 1.0 27/01/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.authentication;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserRepository;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger LOGGER = Logger.getLogger(DefaultAuthenticationProvider.class.getName());
	
	private UserRepository repository;
	private PasswordEncoder encoder;

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		
		final User user = repository.findByUsername(authentication.getName());
		
		if(this.userVerify(user, authentication.getCredentials().toString())) {
			try {
				throw new BadCredentialsExceptions("username/password invalid");
			} catch (final BadCredentialsExceptions e) {
				LOGGER.severe(e.getMessage());
				throw new BadCredentialsException(e.getMessage());
			}
		} 
		
		return new PreAuthenticatedAuthentication(user);
		
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
	/**
	 * valida o usuario, verificando se ele nao eh nulo ou possua as credenciais invalidas
	 * @param user
	 * @param password
	 * @return true em caso de sucesso
	 * 	e false em caso de falha
	 */
	private boolean userVerify(final User user, final String password) {
		return user == null || !encoder.matches(password, user.getPassword());
	}

	@Autowired
	public void setRepository(final UserRepository userRepository) {
		repository = userRepository;
	}
	
	@Autowired
	public void setPasswordEncoder(final PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
}
