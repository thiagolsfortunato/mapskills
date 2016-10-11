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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.gov.sp.fatec.mapskills.domain.student.Student;
import br.gov.sp.fatec.mapskills.domain.student.StudentService;
import br.gov.sp.fatec.mapskills.utils.MultipartParser;
import br.gov.sp.fatec.mapskills.utils.StudentXLSXParser;

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
	private StudentService service;
	
	@RequestMapping(value = "/upload/alunos", method = RequestMethod.POST)
	public ResponseEntity<?> importStudents(@RequestParam("file") final MultipartFile multiPartFile,
			@RequestParam("insId") final int insId) throws Exception {
		final StudentXLSXParser userXLSX = new StudentXLSXParser();
		final List<Student> users = userXLSX.toUserList(new MultipartParser().toFile(multiPartFile));
		service.create(users);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
