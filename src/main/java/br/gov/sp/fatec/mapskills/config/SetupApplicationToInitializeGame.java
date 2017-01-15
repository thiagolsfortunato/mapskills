package br.gov.sp.fatec.mapskills.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
	
	private static final String PATH_TXT = "d:/temp/arquivosTexto/";
	private static final String URL_SERVER = "http://localhost:8080/mapskills/images/";
	private static final long GAME_THEME_ID = 1;
	
	private final Map<Integer, Question> mapQuestion = new HashMap<>(26);
	private final Map<Integer, Collection<Alternative>> mapAlternatives = new HashMap<>(26);
	final List<String> textList = new LinkedList<>();
	
	private SkillRepository skillRepository = BeanRetriever.getBean("skillRepository", SkillRepository.class);
	private SceneService sceneService = BeanRetriever.getBean("sceneService", SceneService.class);
	private GameThemeService themeService = BeanRetriever.getBean("gameThemeService", GameThemeService.class);
	private InstitutionService institutionService = BeanRetriever.getBean("institutionService", InstitutionService.class);
	
	public SetupApplicationToInitializeGame() throws IOException {
		/*this.createInstitution();
		System.err.println("=== institution save success ===".toUpperCase());
		this.createCourses();
		System.err.println("=== courses save success ===".toUpperCase());
		this.creatStudent();
		System.err.println("=== student save success ===".toUpperCase());
		this.createGameTheme();
		System.err.println("=== themes save success ===".toUpperCase());
		this.createSkills();
		System.err.println("=== skills save success ===".toUpperCase());
		this.buildTextFromFile();
		this.generateAlternativesFromFile();
		this.generateQuestions();
		this.createScenesFromFile();
		System.err.println("=== scenes save success ===".toUpperCase());*/
	}
	/**
	 * cria uma nova instituição persistindo-a na base de dados
	 */
	private void createInstitution() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "146", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("146", "66726505000146", "Jessen Vidal", "São José", mentor);
		institutionService.saveInstitution(fatec);
	}
	/**
	 * adiciona cursos a instituição
	 */
	private void createCourses() {
		institutionService.saveCourse(new Course("029", "Logistica", CoursePeriod.NOTURNO, "146"));
		institutionService.saveCourse(new Course("030", "Estruturas Leves", CoursePeriod.NOTURNO, "146"));
		institutionService.saveCourse(new Course("031", "Manutenção de Aeronaves", CoursePeriod.NOTURNO, "146"));
	}
	
	private void creatStudent() {
		institutionService.saveStudent(new Student(new AcademicRegistry("1460291713000", "146", "029"), "Student User", "1289003400", "student@fatec.sp.gov.br", "mudar@123"));
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
	@SuppressWarnings("resource")
	public void createScenesFromFile() throws IOException {
		final String filePath = PATH_TXT.concat("sequenciaImagensCenasTemaPizzaria.txt");
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		
		int idQuestion = 1;
		int cont = 0;
		String linha = null;
		while((linha = reader.readLine()) != null) {
			if(cont % 3 == 1) {
				sceneService.save(new Scene(textList.get(cont), URL_SERVER.concat(linha), mapQuestion.get(idQuestion), GAME_THEME_ID));
				idQuestion++;
				cont++;
				continue;
			}
			sceneService.save(new Scene(textList.get(cont), URL_SERVER.concat(linha), null, GAME_THEME_ID));
			cont++;
		}
		
	}
	
	/**
	 * cria competencias persistindo-as na base de dados
	 */
	public void createSkills() {
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
	@SuppressWarnings("resource")
	private void buildTextFromFile() throws IOException {
		final String filePath = PATH_TXT.concat("textosTemaPizzaria.txt");
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		
		String linha = null;
		while((linha = reader.readLine()) != null) {
			this.textList.add(linha);
		}
	}
	/**
	 * realizando leitura do arquivo contendo as alternativas de cada questão e
	 * popula o mapa de int/List<Alternatives>
	 * gerando o valor do peso da alternativa aleatoriamente entre 0 e 6
	 * @throws IOException caso haja algum problema I/O
	 * 
	 */
	@SuppressWarnings("resource")
	private void generateAlternativesFromFile() throws IOException {
		this.mapAlternatives.clear();
		final String filePath = PATH_TXT.concat("alternativasTemaPizzaria.txt");
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		
		final Random gerador = new Random();
		String linha = null;
		int idQuestion = 1;
		while((linha = reader.readLine()) != null) {
			final List<Alternative> alternatives = new LinkedList<>();
			for(int i = 0; i < 4; i++) {
				alternatives.add(new Alternative(linha, gerador.nextInt(7)));
				linha = reader.readLine();
			}
			mapAlternatives.put(idQuestion, alternatives);
			idQuestion++;
		}
		
	}
	
}
