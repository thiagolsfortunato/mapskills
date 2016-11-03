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

import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.StudentPoiParser;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InputStreamWrapper;

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
	private UserService service;

	@RequestMapping(value = "/upload/students", method = RequestMethod.POST)
	public ResponseEntity<?> importStudents(@RequestBody final InputStreamWrapper inputStreamWrapper) throws Exception {
		
		final StudentPoiParser studentPoi = new StudentPoiParser();
		final List<Student> students = studentPoi.toObjectList(inputStreamWrapper.getInputStream());
		studentPoi.setInstitutionId(students, inputStreamWrapper.getInstitutionId());
		service.create(students);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
