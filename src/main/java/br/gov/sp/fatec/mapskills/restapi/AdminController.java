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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionPoiParser;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.GameThemeWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InputStreamWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionListWrapper;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionWrapper;

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
	private GameThemeService themeService;
	
	@Autowired
	private InstitutionService institutionService;
	
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
	public ResponseEntity<?> saveInstitution(@RequestBody final InstitutionWrapper institutionWrapper) throws Exception {
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
	
	/***
	 * Método que retorna todos temas cadastrados na aplicação
	 * @return
	 */
	@RequestMapping(value = "/game/theme", method = RequestMethod.GET)
	public ResponseEntity<GameThemeListWrapper> getAllThemes() {
		final GameThemeListWrapper gameThemes = new GameThemeListWrapper(themeService.findAllThemes()); 
		return new ResponseEntity<>(gameThemes, HttpStatus.OK);
	}

}
