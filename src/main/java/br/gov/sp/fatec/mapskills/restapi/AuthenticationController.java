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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.UserWrapper;

/**
 * A classe <code>AuthenticationController</code> eh responsavel por conter a
 * rota (uri) de detalhes do usuario logado na aplicação.
 * 
 * @author Marcelo
 *
 */
@RestController
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Metodo que retorna os detalhes do usuário logado na aplicacao.
	 * @param username
	 * @return <code>ResponseEntity -UserWrapper-</code>
	 */
	@RequestMapping(value = "/user/details", method = RequestMethod.POST)
	public ResponseEntity<UserWrapper> login(@RequestParam("username") String username) {
		
		final User user = userService.findByUsername(username);
		final UserWrapper userWrapper = new UserWrapper(user);
		return new ResponseEntity<>(userWrapper, HttpStatus.OK);
	}

}
