/*
 * @(#)MapSkillsController.java 1.0 30/09/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionPoiParser;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.StudentPoiParser;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InputStreamWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.LoginWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.UserWrapper;

/**
 * A classe <code>MapSkillsController</code> é responsavel por conter as rotas
 * de controle da aplicação.
 * 
 * @author Marcelo Inácio
 *
 */
@RestController
public class StudentController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InstitutionService institutionService;

	@RequestMapping(value = "/upload/students", method = RequestMethod.POST)
	public ResponseEntity<?> importStudents(@RequestBody final InputStreamWrapper inputStreamWrapper) throws Exception {
		final StudentPoiParser studentPoi = new StudentPoiParser();
		final List<Student> students = studentPoi.toObjectList(inputStreamWrapper.getInputStream());
		institutionService.saveStudents(students);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/upload/institutions", method = RequestMethod.POST)
	public ResponseEntity<?> importInstitutions(@RequestBody final InputStreamWrapper inputStreamWrapper) throws Exception {
		final InstitutionPoiParser institutionPoi = new InstitutionPoiParser();
		final List<Institution> institutions = institutionPoi.toObjectList(inputStreamWrapper.getInputStream());
		institutionService.saveInstitutions(institutions);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserWrapper> login(@RequestBody final LoginWrapper loginWrapper) throws MapSkillsException {
		final User user = userService.findUserByUsernamePassword(loginWrapper.username(), loginWrapper.password());
		final UserWrapper userWrapper = new UserWrapper(user);
		return new ResponseEntity<>(userWrapper, HttpStatus.OK);
	}


}
