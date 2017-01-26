/*
 * @(#)SetupApplicationToInitializeGame.java 1.0 20/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Configuration;

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.scene.Alternative;
import br.gov.sp.fatec.mapskills.domain.scene.Question;
import br.gov.sp.fatec.mapskills.domain.scene.Scene;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillRepository;
import br.gov.sp.fatec.mapskills.domain.theme.GameTheme;
import br.gov.sp.fatec.mapskills.domain.theme.GameThemeService;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.utils.BeanRetriever;

@Configuration
public class SetupApplicationToInitializeGame {
	
	private static final Logger LOGGER = Logger.getLogger(SetupApplicationToInitializeGame.class.getName());
	
	private static final String PATH_TXT = "d:/temp/arquivosTexto/";
//	private static final String URL_SERVER = "http://webapp-inacio.rhcloud.com/mapskills/images/";
	private static final String URL_SERVER = "http://localhost:8585/mapskills/images/";
	private static final long GAME_THEME_ID = 1;
	private static final String INSTITUTION_CODE = "147";
	
	private final Map<Integer, Question> mapQuestion = new HashMap<>(26);
	private final Map<Integer, Collection<Alternative>> mapAlternatives = new HashMap<>(26);
	final List<String> textList = new LinkedList<>();
	
	private SkillRepository skillRepository = BeanRetriever.getBean("skillRepository", SkillRepository.class);
	private SceneService sceneService = BeanRetriever.getBean("sceneService", SceneService.class);
	private GameThemeService themeService = BeanRetriever.getBean("gameThemeService", GameThemeService.class);
	private InstitutionService institutionService = BeanRetriever.getBean("institutionService", InstitutionService.class);
	
	public SetupApplicationToInitializeGame() throws IOException {
		this.createInstitution();
		LOGGER.log(Level.INFO, "=== INSTITUTION SAVE SUCCESS ===");
		this.createCourses();
		LOGGER.log(Level.INFO, "=== COURSES SAVE SUCCESS ===");
		this.creatStudent();
		LOGGER.log(Level.INFO, "=== STUDENT SAVE SUCCESS ===");
		this.createGameTheme();
		LOGGER.log(Level.INFO, "=== THEMES SAVE SUCCESS ===");
		this.createSkills();
		LOGGER.log(Level.INFO, "=== SKILLS SAVE SUCCESS ===");
		this.buildTextFromFile();
		this.generateAlternatives();
		this.generateQuestions();
		this.createScenesFromFile();
		LOGGER.log(Level.INFO, "=== SCENES SAVE SUCCESS ===");
	}
	/**
	 * cria uma nova instituição persistindo-a na base de dados
	 */
	private void createInstitution() {
		institutionService.deleteAll();
		final Mentor mentor = new Mentor("Sidney", INSTITUTION_CODE, "sidney@fatec.sp.gov.br", "Mudar@123");
		final Institution fatec = new Institution(INSTITUTION_CODE, "56381708000194", "Jessen Vidal", "São José", mentor);
		institutionService.saveInstitution(fatec);
	}
	/**
	 * adiciona cursos a instituição
	 */
	private void createCourses() {
		institutionService.saveCourse(new Course("050", "Logistica", CoursePeriod.NOTURNO, INSTITUTION_CODE));
		institutionService.saveCourse(new Course("060", "Estruturas Leves", CoursePeriod.NOTURNO, INSTITUTION_CODE));
		institutionService.saveCourse(new Course("070", "Manutenção de Aeronaves", CoursePeriod.NOTURNO, INSTITUTION_CODE));
	}
	
	private void creatStudent() {
		if(institutionService.findStudentByRa(INSTITUTION_CODE+"0501713000") != null) {
			institutionService.saveStudent(new Student(new AcademicRegistry(INSTITUTION_CODE+"0501713000", INSTITUTION_CODE, "050"), "Student User", "1289003400", "aluno@fatec.sp.gov.br", "mudar@123"));			
		}
	}
	/**
	 * cria um tema e persiste-a na base de dados
	 */
	private void createGameTheme() {
		themeService.save(new GameTheme("PIZZARIA"));
	}
	/**
	 * cria uma carga inicial das cenas persistindo-as na base de dados,
	 * há uma sequencia de questões entre as cenas
	 * (i.e. cena 1 não tem questão, cena 2 tem questão e cena 3 não tem questão)
	 * @throws IOException caso ocorra um problema de leitura do arquivo
	 * 			texto com os nomes das imagens de cada cena (i.e. scene01.jpg)
	 */
	private void createScenesFromFile() throws IOException {
		final String filePath = PATH_TXT.concat("sequenciaImagensCenasTemaPizzaria.txt");
		
		int idQuestion = 1;
		int imageIndex = 0;
		for(final String line : this.buildReaderFromFile(filePath)) {
			if(imageIndex % 3 == 1) {
				sceneService.save(new Scene(textList.get(imageIndex++), URL_SERVER.concat(line), mapQuestion.get(idQuestion++), GAME_THEME_ID));
				continue;
			}
			sceneService.save(new Scene(textList.get(imageIndex++), URL_SERVER.concat(line), null, GAME_THEME_ID));
		}
	}
	
	/**
	 * cria competencias persistindo-as na base de dados
	 */
	private void createSkills() {
		skillRepository.save(new Skill("Visão do futuro", "Avalia projeção de perspectiva."));
		skillRepository.save(new Skill("Comunicação", "Avalia dicção dos assuntos em grupo."));
		skillRepository.save(new Skill("Gestão do tempo", "Avaliação a situação sob pressão no trabalho."));
		skillRepository.save(new Skill("Equilibrio emocional", "Avalia o comportamento em situação de stress."));
		skillRepository.save(new Skill("Trabalho em equipe", "Avalia a gestão do trablho em equipe."));
		skillRepository.save(new Skill("Resiliencia", "Avalia a facilidade de se adaptar às mudanças."));
	}
	/**
	 * popula mapa de questões, sendo a lista de alternativas recuperada
	 * do mapa de alternativas populada anteriormente.
	 * há cenas que não possuem questão.
	 */
	private void generateQuestions() {
		final Random gerador = new Random();
		for(int i = 1; i < 26; i++) {
			mapQuestion.put(i, new Question(mapAlternatives.get(i), gerador.nextInt(6) + 1));
		}
	}
	
	/**
	 * popula a lista de textos, realizando leitura do arquivo contendo
	 * os texto das cenas.
	 * @throws IOException
	 */
	private void buildTextFromFile() throws IOException {
		final String filePath = PATH_TXT.concat("textosTemaPizzaria.txt");
		this.textList.addAll(this.buildReaderFromFile(filePath));
	}
	/**
	 * realizando leitura do arquivo contendo as alternativas de cada questão e
	 * popula o mapa de int/List<Alternatives>
	 * gerando o valor do peso da alternativa aleatoriamente entre 0 e 6
	 * @throws IOException caso haja algum problema I/O
	 * 
	 */
	private void generateAlternatives() throws IOException {
		this.mapAlternatives.clear();
		final String filePath = PATH_TXT.concat("alternativasTemaPizzaria.txt");
		
		final Random gerador = new Random();
		int idQuestion = 1;

		final List<String> list = new ArrayList<>();
		list.addAll(this.buildReaderFromFile(filePath));
		final int sizeList = list.size();
		for(int i = 0; i < sizeList; i++) {
			final List<Alternative> alternatives = new LinkedList<>();
			for(int j = 0; j < 4; j++) {
				alternatives.add(new Alternative(list.get(i++), gerador.nextInt(7)));
			}
			mapAlternatives.put(idQuestion++, alternatives);
		}
	}
	/**
	 * cria uma lista de string, apartir do caminho de um arquivo txt.
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	private Collection<String> buildReaderFromFile(final String filePath) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		final Collection<String> lineList = new ArrayList<>();
		String lineTmp;
		while((lineTmp = reader.readLine()) != null) {
			lineList.add(lineTmp);
		}
		reader.close();
		return Collections.unmodifiableCollection(lineList);
	}
	
}
