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
import br.gov.sp.fatec.mapskills.utils.BeanRetriever;

@Configuration
public class SetupApplicationToInitializeGame {
	
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
		this.createInstitution();
		this.createGameTheme();
		this.createSkills();
		this.buildTextFromFile();
		this.generateAlternativesFromFile();
		this.generateQuestions();
		this.createScenes();
	}
	
	private void createInstitution() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "146", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("146", "66726505000146", "Jessen Vidal", "São José", mentor);
		institutionService.saveInstitution(fatec);
	}
	/**
	 * cria tema no banco de dados
	 */
	private void createGameTheme() {
		themeService.save(new GameTheme("PIZZARIA"));
	}
	
	public void createScenes() {
		sceneService.save(new Scene(textList.get(0), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(1), URL_SERVER.concat("scene1.jpg"), mapQuestion.get(1), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(2), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(3), URL_SERVER.concat("scene3.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(4), URL_SERVER.concat("scene3.jpg"), mapQuestion.get(2), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(5), URL_SERVER.concat("scene3.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(6), URL_SERVER.concat("scene4.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(7), URL_SERVER.concat("scene4.jpg"), mapQuestion.get(3), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(8), URL_SERVER.concat("scene4.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(9), URL_SERVER.concat("scene5.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(10), URL_SERVER.concat("scene6.jpg"), mapQuestion.get(4), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(11), URL_SERVER.concat("scene6.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(12), URL_SERVER.concat("scene7.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(13), URL_SERVER.concat("scene7.jpg"), mapQuestion.get(5), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(14), URL_SERVER.concat("scene7.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(15), URL_SERVER.concat("scene8.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(16), URL_SERVER.concat("scene8.jpg"), mapQuestion.get(6), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(17), URL_SERVER.concat("scene9.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(18), URL_SERVER.concat("scene10.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(19), URL_SERVER.concat("scene11.jpg"), mapQuestion.get(7), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(20), URL_SERVER.concat("scene11.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(21), URL_SERVER.concat("scene12.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(22), URL_SERVER.concat("scene12.jpg"), mapQuestion.get(8), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(23), URL_SERVER.concat("scene12.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(24), URL_SERVER.concat("scene13.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(25), URL_SERVER.concat("scene14.jpg"), mapQuestion.get(9), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(26), URL_SERVER.concat("scene14.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(27), URL_SERVER.concat("scene15.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(28), URL_SERVER.concat("scene15.jpg"), mapQuestion.get(10), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(29), URL_SERVER.concat("scene15.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(30), URL_SERVER.concat("scene16.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(31), URL_SERVER.concat("scene16.jpg"), mapQuestion.get(11), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(32), URL_SERVER.concat("scene16.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(33), URL_SERVER.concat("scene18.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(34), URL_SERVER.concat("scene18.jpg"), mapQuestion.get(12), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(35), URL_SERVER.concat("scene18.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(36), URL_SERVER.concat("scene19.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(37), URL_SERVER.concat("scene19.jpg"), mapQuestion.get(13), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(38), URL_SERVER.concat("scene19.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(39), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(40), URL_SERVER.concat("scene20.jpg"), mapQuestion.get(14), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(41), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(42), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(43), URL_SERVER.concat("scene22.jpg"), mapQuestion.get(15), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(44), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(45), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(46), URL_SERVER.concat("scene22.jpg"), mapQuestion.get(16), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(47), URL_SERVER.concat("scene22.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(48), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(49), URL_SERVER.concat("scene23.jpg"), mapQuestion.get(17), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(50), URL_SERVER.concat("scene23.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(51), URL_SERVER.concat("scene24.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(52), URL_SERVER.concat("scene25.jpg"), mapQuestion.get(18), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(53), URL_SERVER.concat("scene24.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(54), URL_SERVER.concat("scene26.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(55), URL_SERVER.concat("scene26.jpg"), mapQuestion.get(19), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(56), URL_SERVER.concat("scene26.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(57), URL_SERVER.concat("scene27.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(58), URL_SERVER.concat("scene27.jpg"), mapQuestion.get(20), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(59), URL_SERVER.concat("scene27.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(60), URL_SERVER.concat("scene28.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(61), URL_SERVER.concat("scene28.jpg"), mapQuestion.get(21), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(62), URL_SERVER.concat("scene28.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(63), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(64), URL_SERVER.concat("scene1.jpg"), mapQuestion.get(22), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(65), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(66), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(67), URL_SERVER.concat("scene1.jpg"), mapQuestion.get(23), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(68), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(69), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(70), URL_SERVER.concat("scene20.jpg"), mapQuestion.get(24), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(71), URL_SERVER.concat("scene20.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(72), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(73), URL_SERVER.concat("scene1.jpg"), mapQuestion.get(25), GAME_THEME_ID));
		sceneService.save(new Scene(textList.get(74), URL_SERVER.concat("scene1.jpg"), null, GAME_THEME_ID));
	}
	/**
	 * cria competencias no banco de dados
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
	 * insere no mapa questões para serem salva junto com a cena que possui questão,
	 * pois há cenas que não possuem questão.
	 */
	private void generateQuestions() {
		final Random gerador = new Random();
		for(int i = 1; i < 26; i++) {
			mapQuestion.put(i, new Question(mapAlternatives.get(i), gerador.nextInt(6) + 1));
		}
	}
	
	/**
	 * realiza leitura do arquivo contendo os texto das cenas e adiciona as linhas em uma lista
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private void buildTextFromFile() throws IOException {
		final String filePath = "d:/temp/arquivosTexto/textosTemaPizzaria.txt";
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		
		String linha = null;
		while((linha = reader.readLine()) != null) {
			this.textList.add(linha);
		}
	}
	/**
	 * realiza leitura do arquivo contendo as alternativas de cada questão e
	 * monta um mapa de int/List<Alternatives>
	 * gerando o valor do peso da alternativa aleatoriamente entre 0 e 6
	 * @throws IOException caso haja algum problema I/O
	 * 
	 */
	@SuppressWarnings("resource")
	private void generateAlternativesFromFile() throws IOException {
		this.mapAlternatives.clear();
		final String filePath = "d:/temp/arquivosTexto/alternativasTemaPizzaria.txt";
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filePath)));
		
		final Random gerador = new Random();
		String linha = null;
		int index = 1;
		while((linha = reader.readLine()) != null) {
			final List<Alternative> alternatives = new LinkedList<>();
			for(int i = 0; i < 4; i++) {
				alternatives.add(new Alternative(linha, gerador.nextInt(7)));
				linha = reader.readLine();
			}
			mapAlternatives.put(index, alternatives);
			index++;
		}
		
	}
	

}
