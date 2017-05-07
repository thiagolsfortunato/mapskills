/*
 * @(#)MapSkillsMockBeans.java 1.0 08/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.domain.user.UserRepository;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.student.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
/**
 * 
 * A classe {@link MapSkillsMockBeans} contem metodos
 * que retornam instancias dos objetos de dominio
 * para que sejam feitos testes.
 *
 * @author Marcelo
 * @version 1.0 08/01/2017
 */
@Configuration
public class MapSkillsMockBeans {
	
	private static final String SUCCESS = "SUCCESS"; 
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private InstitutionService institutionService;
	
	@Autowired
	private GameThemeService themeService;
	
	@Autowired
	private SceneService sceneService;
	
	@Autowired
	private SkillService skillService;
	
	@Bean
	public String saveAdmin() {
		final Administrator admin = new Administrator("Administrador", "admin@cps.sp.gov.br", "admin");
		userRepo.save(admin);
		return SUCCESS;
	}
	
	@Bean
	public String saveInstitution() {
		final Collection<Institution> institutions = new ArrayList<>(1);
		final Institution fatecA = new Institution("146", "60565187000100", "Jessen Vidal", InstitutionLevel.SUPERIOR,"São José");
		fatecA.addMentor(new Mentor("Marquinhos", "146", "marquinhos@cps.sp.gov.br", "mudar@123"));
		institutions.add(fatecA);
		institutionService.saveInstitutions(institutions);
		
		return SUCCESS;
	}
	
	@Bean
	public String saveStudent() throws MapSkillsException {
		final Student student = new Student(new AcademicRegistry("1460281423050", "146", "028"), "Student MockE", "1289003400", "student@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(student);
		return SUCCESS;
	}
	
	@Bean
	public String saveGameTheme() {
		themeService.save(GameTheme.builder().name("pizzaria, aplicado em 2016/2").build());
		themeService.save(GameTheme.builder().name("empresa de musica, aplicado em 2017/1").build());
		return SUCCESS;
	}
	
	@Bean
	public String saveScenes() {
		final int THEME_ID = 1;
		final int SKILL_ID = 1;
		final Collection<Alternative> alternatives = new ArrayList<>(4);
		alternatives.addAll(builderMockAlternatives());
		final Question question = Question.builder().alternatives(alternatives).skillId(SKILL_ID).build();

		sceneService.save(Scene.builder().text("introdução").urlBackground("url://site/img001.png")
				.question(null).gameThemeId(THEME_ID).build());

		sceneService.save(Scene.builder().text("questão").urlBackground("url://site/img002.png")
				.question(question).gameThemeId(THEME_ID).build());
		
		sceneService.save(Scene.builder().text("conclusão").urlBackground("url://site/img003.png")
				.question(null).gameThemeId(THEME_ID).build());
		
		return SUCCESS;
	}
	
	@Bean
	public String saveSkills() {		
		skillService.save(Skill.builder().type("Comunicação").description("Avalia a dicção do aluno").build());
		skillService.save(Skill.builder().type("Liderança").description("Avalia a liderança do aluno").build());
		skillService.save(Skill.builder().type("Gestão de Tempo").description("Avalia a gestão de tempo do aluno").build());
		
		return SUCCESS;
	}
	
	private Collection<Alternative> builderMockAlternatives() {
		final Collection<Alternative> alternatives = new ArrayList<>(4);
		alternatives.add(Alternative.builder().description("AlternativaMockA").skillValue(8).build());
		alternatives.add(Alternative.builder().description("AlternativaMockB").skillValue(5).build());
		alternatives.add(Alternative.builder().description("AlternativaMockC").skillValue(6).build());
		alternatives.add(Alternative.builder().description("AlternativaMockD").skillValue(4).build());
		return alternatives;
	}

}
