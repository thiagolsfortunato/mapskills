/*
 * @(#)MapSkillsController.java 1.0 30/09/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.AnswerWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentResultWrapper;
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
    private ServletContext servletContext;
	
	@Autowired
	private SceneService sceneService;
	
	@RequestMapping(value = "/game/answer", method = RequestMethod.POST)
	public ResponseEntity<?> saveAnswer(@RequestBody final AnswerWrapper answerWrapper) {
		sceneService.saveAnswer(answerWrapper.getAnswerContext());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/game/result/{studentID}", method = RequestMethod.GET)
	public ResponseEntity<StudentResultWrapper> getResult(@PathVariable("studentID") final long studentID) {
		final List<Object[]> context = sceneService.getResultByStudentId(studentID);
		final StudentResultWrapper result = new StudentResultWrapper(context);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/game/image/{filename}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImageByFilename(@PathVariable("filename") final String filename) throws IOException {
		HttpHeaders headers = new HttpHeaders();
	    InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
	    byte[] media = IOUtils.toByteArray(in);
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		
		return new ResponseEntity<>(media, headers, HttpStatus.OK);
	}

}
