/*
 * @(#)AdminController.java 1.0 03/01/2017
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

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionPoiParser;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InputStreamWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionDetailsWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SceneWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SkillListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.SkillWrapper;
import br.gov.sp.fatec.mapskills.utils.SaveImageService;

/**
 * A classe <code>AdminController</code> é responsável por conter todas
 * rotas (uri's) do perfil administrador da aplicação.
 * 
 * @author Marcelo
 *
 */
@RestController
public class AdminController {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private GameThemeService themeService;
	
	@Autowired
	private SceneService sceneService;
	
	@Autowired
	private InstitutionService institutionService;
	
	@Autowired
	private SaveImageService imageService;
	
	/**
	 * Método que realiza a persistencia de lista de instituições por meio de um arquivo
	 * excel .(xlsx) feito pelo perfil <code>ADMINISTRATOR</code>
	 * @param inputStreamWrapper
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload/institutions", method = RequestMethod.POST)
	public ResponseEntity<?> importInstitutions(@RequestBody final InputStreamWrapper inputStreamWrapper) throws Exception {
		final InstitutionPoiParser institutionPoi = new InstitutionPoiParser();
		final List<Institution> institutions = institutionPoi.toObjectList(inputStreamWrapper.getInputStream());
		institutionService.saveInstitutions(institutions);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Método que realiza a persistencia de uma unica instituição
	 * realizado pelo perfil <code>ADMINISTRATOR</code>
	 * @param inputStreamWrapper
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/institution", method = RequestMethod.POST)
	public ResponseEntity<?> saveInstitution(@RequestBody final InstitutionDetailsWrapper institutionWrapper) throws Exception {
		institutionService.saveInstitution(institutionWrapper.getInstitution());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Método que recuepra todas instituicoes cadastradas na aplicacao
	 * realizado pelo perfil <code>ADMINISTRATOR</code>
	 * @return
	 */
	@RequestMapping(value = "/institutions", method = RequestMethod.GET)
	public ResponseEntity<InstitutionListWrapper> getAllInstitution() {
		final InstitutionListWrapper institutions = new InstitutionListWrapper(institutionService.findAllInstitutions());
		return new ResponseEntity<>(institutions, HttpStatus.OK);
	}
	/**
	 * Método que recupera um instituição em detalhes
	 * @param institutionId
	 * @return
	 * @throws MapSkillsException 
	 */
	@RequestMapping(value = "/institution/{institutionId}", method = RequestMethod.GET)
	public ResponseEntity<InstitutionDetailsWrapper> getInstitutionDetail(@PathVariable("institutionId") final long institutionId) throws MapSkillsException {
		final Institution institution = institutionService.findInstitutionDetailsById(institutionId);
		final InstitutionDetailsWrapper institutionDetail = new InstitutionDetailsWrapper(institution);
		return new ResponseEntity<>(institutionDetail, HttpStatus.OK);
	}
	
	/**
	 * Método que realiza a persistencia de um tema na aplicação feito
	 * pelo perfil <code>ADMINISTRATOR</code>
	 * @param themeWrapper
	 * @return
	 */
	@RequestMapping(value = "/game/theme", method = RequestMethod.POST)
	public ResponseEntity<?> saveTheme(@RequestBody final GameThemeWrapper themeWrapper) {
		themeService.save(themeWrapper.getGameTheme());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/game/themes", method = RequestMethod.PUT)
	public ResponseEntity<?> updateThemes(@RequestBody final GameThemeListWrapper themeWrapper) {
		themeService.save(themeWrapper.getGameThemes());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/***
	 * Método que retorna todos temas cadastrados na aplicação
	 * @return
	 */
	@RequestMapping(value = "/game/themes", method = RequestMethod.GET)
	public ResponseEntity<GameThemeListWrapper> getAllThemes() {
		final GameThemeListWrapper gameThemes = new GameThemeListWrapper(themeService.findAllThemes()); 
		return new ResponseEntity<>(gameThemes, HttpStatus.OK);
	}
	/**
	 * Método que salva uma cena de um tema do jogo na aplicação
	 * @param sceneWrapper
	 * @return
	 * @throws MapSkillsException 
	 */
	@RequestMapping(value = "/game/scene", method = RequestMethod.POST)
	public ResponseEntity<?> saveScene(@RequestBody final SceneWrapper sceneWrapper) throws MapSkillsException {
		imageService.save(sceneWrapper.getBase64(), sceneWrapper.getFileName());
		sceneService.save(sceneWrapper.getScene());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/**
	 * Realiza atualização de uma lista de cenas, (i.e. a ordem de exibição)
	 * @param sceneListWrapper
	 * @return
	 */
	@RequestMapping(value = "/game/scenes", method = RequestMethod.PUT)
	public ResponseEntity<?> updateIndexScenes(@RequestBody final SceneListWrapper sceneListWrapper) {
		sceneService.updateIndex(sceneListWrapper.getScenes());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/**
	 * Método que retorna todas as cenas de um tema da aplicação
	 * @param themeId
	 * @return
	 */
	@RequestMapping(value = "/game/theme/{themeId}", method = RequestMethod.GET)
	public ResponseEntity<SceneListWrapper> getAllScenesByThemeId(@PathVariable("themeId") final long themeId) {
		final SceneListWrapper scenesListWrapper = new SceneListWrapper(themeService.findAllScenesByThemeId(themeId));
		return new ResponseEntity<>(scenesListWrapper, HttpStatus.OK);
	}
	/**
	 * Salva uma nova competência na aplicação
	 * @param skillWrapper
	 * @return
	 */
	@RequestMapping(value = "/skill", method = RequestMethod.POST)
	public ResponseEntity<?> saveSkill(@RequestBody final SkillWrapper skillWrapper) {
		skillService.save(skillWrapper.getSkill());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/**
	 * Retorna uma array serializado com todas competencias cadastradas na aplicação.
	 * @return
	 */
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public ResponseEntity<SkillListWrapper> getAllSkills() {
		final SkillListWrapper gameThemes = new SkillListWrapper(skillService.findAll()); 
		return new ResponseEntity<>(gameThemes, HttpStatus.OK);
	}

}
