/*
 * @(#)MapSkillsTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.gov.sp.fatec.mapskills.config.WebConfig;
import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;
/**
 * 
 * A classe {@link MapSkillsTest} possui metodos
 * para criacao de objetos de dominio para realizacao
 * de testes.
 *
 * @author Marcelo
 * @version 1.0 29/12/2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextConfigurationTest.class, WebConfig.class})
@WebAppConfiguration
public abstract class MapSkillsTest {
	
	@Autowired
	protected SkillService skillService;
	
	protected void cleanTables(final RepositoryService... services) {
		for(final RepositoryService service : services) {
			final String serviceName = service.getClass().getSimpleName();
			System.err.println("limpando dados da tabela " + serviceName.replace("Service", "").toUpperCase());
			service.deleteAll();
		}
	}
	
	protected List<Scene> buildMockScenes(final long themeId) {
		final List<Alternative> alternatives = builderMockAlternatives(); 
		final List<Scene> scenes = new ArrayList<>(6);
		
		scenes.add(Scene.builder().text("olá sente-se").urlBackground("/scenes/bg001.png").question(null).gameThemeId(themeId).build());
		scenes.add(Scene.builder().text("me diga um qualidade").urlBackground("/scenes/bg002.png").question(Question.builder().alternatives(alternatives).skillId(1).build()).gameThemeId(themeId).build());
		scenes.add(Scene.builder().text("muito bom").urlBackground("/scenes/bg003.png").question(null).gameThemeId(themeId).build());
		scenes.add(Scene.builder().text("qual sua primeira atitude?").urlBackground("/scenes/bg004.png").question(null).gameThemeId(themeId).build());
		scenes.add(Scene.builder().text("qual sua primeira atitude?").urlBackground("/scenes/bg005.png").question(Question.builder().alternatives(alternatives).skillId(2).build()).gameThemeId(themeId).build());
		scenes.add(Scene.builder().text("bem pensado!").urlBackground("/scenes/bg006.png").question(null).gameThemeId(themeId).build());
		
		return scenes;
	}
	
	protected List<Alternative> builderMockAlternatives() {
		final List<Alternative> alternatives = new ArrayList<>(4);
		alternatives.add(Alternative.builder().description("AlternativaMockA").skillValue(8).build());
		alternatives.add(Alternative.builder().description("AlternativaMockB").skillValue(5).build());
		alternatives.add(Alternative.builder().description("AlternativaMockC").skillValue(6).build());
		alternatives.add(Alternative.builder().description("AlternativaMockD").skillValue(4).build());
		return alternatives;
	}
	
	protected List<Skill> buildSkillsMock() {
		final List<Skill> skills = new ArrayList<>();
		skills.add(Skill.builder().type("Visão do futuro").description("").build());
		skills.add(Skill.builder().type("Comunicação").description("").build());
		skills.add(Skill.builder().type("Gestão do tempo").description("").build());
		skills.add(Skill.builder().type("Equilibrio emocional").description("").build());
		return skills;
	}

}
