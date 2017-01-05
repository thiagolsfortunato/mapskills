/*
 * @(#)AuthenticationController.java 1.0 03/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.LoginWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.UserWrapper;

/**
 * A classe <code>AuthenticationController</code> é responsável por conter todas
 * rotas (uri's) de autenticação da aplicação.
 * 
 * @author Marcelo
 *
 */
@RestController
public class AuthenticationController {
	
	
	@Autowired
	private UserService userService;
	
	/**
	 * Metodo que realiza login na aplicacao
	 * @param loginWrapper
	 * @return
	 * @throws MapSkillsException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserWrapper> login(@RequestBody final LoginWrapper loginWrapper) throws MapSkillsException {
		final User user = userService.findUserByUsernamePassword(loginWrapper.username(), loginWrapper.password());
		final UserWrapper userWrapper = new UserWrapper(user);
		return new ResponseEntity<>(userWrapper, HttpStatus.OK);
	}

}
