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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.AnswerWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.StudentResultWrapper;
/**
 * A classe <code>MapSkillsController</code> é responsavel por conter as rotas
 * de controle da aplicação.
 * 
 * @author Marcelo Inácio
 *
 */
@RestController
@RequestMapping(StudentController.BASE_PATH)
public class StudentController {
	
	public static final String BASE_PATH = "/student";
	
	@Autowired
	private SceneService sceneService;
	
	/**
	 * realiza a persistencia de um contexto de resposta feita pelo aluno
	 * durante a realização do jogo, ou seja cada click de uma alternativa
	 * dispara este post.
	 * @param answerWrapper contexto de id's da alternativa respondida
	 * @return success ao concluir o post
	 */
	@RequestMapping(value = "/game/answer", method = RequestMethod.POST)
	public ResponseEntity<?> saveAnswer(@RequestBody final AnswerWrapper answerWrapper) {
		sceneService.saveAnswer(answerWrapper.getAnswerContext());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/**
	 * recupera os resultados do aluno ao finalizar o jogo.
	 * @param studentID
	 * @return
	 */
	@RequestMapping(value = "/game/result/{studentID}", method = RequestMethod.GET)
	public ResponseEntity<StudentResultWrapper> getResult(@PathVariable("studentID") final long studentID) {
		final List<Object[]> context = sceneService.getResultByStudentId(studentID);
		final StudentResultWrapper result = new StudentResultWrapper(context);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/game/{studentID}", method = RequestMethod.GET)
	public ResponseEntity<SceneListWrapper> findAllByEnableAndNotAnaswerByStudent(@PathVariable("studentID") final long studentID) {
		final SceneListWrapper scenesListWrapper = new SceneListWrapper(sceneService.findAllNotAnsweredByStudent(studentID));
		return new ResponseEntity<>(scenesListWrapper, HttpStatus.OK);
	}


}
