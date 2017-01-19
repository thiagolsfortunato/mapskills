package br.gov.sp.fatec.mapskills.test.unit;

import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;
import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEventRepository;
import br.gov.sp.fatec.mapskills.domain.scene.SceneService;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class StudentTest extends MapSkillsTest {
	
	@Autowired
	private SceneService sceneService;
	
	@Autowired
	private AnswerEventRepository repo;
	
	@Autowired
	private SkillService skillService;
	
	@After
	public void cleanTables() {
		super.cleanTables(sceneService, skillService);
	}
	
	@Ignore @Test
	public void getResultByStudent() {
		prepareAnswerContext();
		
		final List<Object[]> result = sceneService.getResultByStudentId(1);
		System.err.print("'label': [");
		for(final Object[] r : result) {
			System.err.print("'" + r[0] + "', ");
		}
		System.err.println("]");
		System.err.print("'datasets': [");
		for(final Object[] r : result) {
			System.err.print("'" + r[1] + "', ");
		}
		System.err.println("]");

	}
	
	@Ignore @Test
	public void testResultSkill() {
		prepareAnswerContext();
		repo.findResultSkillByStudentId(1);
	}
	
	//@Test
	public void testResultView() {
		prepareAnswerContext();
		repo.findResultViewByStudentId(1);
	}
	
	private void prepareAnswerContext() {
		final long SCENEID = 1;
		final int SCENE_INDEX = 1;
		final long STUDENTID = 1;
		final int SKILLVALUE = 10;
		
		final Skill skillA = new Skill("liderança", "liderança ...");
		final Skill skillB = new Skill("persuasão", "persuasão ...");
		final Skill skillC = new Skill("visão de futuro", "visão de futuro ...");
		skillService.save(skillA);
		skillService.save(skillB);
		skillService.save(skillC);
		
		for(int i = 0; i < 3; i++ ) {
			final AnswerEvent answer = new AnswerEvent(SCENE_INDEX + i, SCENEID + i, STUDENTID, skillA.getId(), SKILLVALUE + 1);
			sceneService.saveAnswer(answer);
		}
		for(int i = 3; i < 6; i++ ) {
			final AnswerEvent answer = new AnswerEvent(SCENE_INDEX + i, SCENEID + i, STUDENTID, skillB.getId(), SKILLVALUE + 2);
			sceneService.saveAnswer(answer);
		}
		for(int i = 6; i < 9; i++ ) {
			final AnswerEvent answer = new AnswerEvent(SCENE_INDEX + i, SCENEID + i, STUDENTID, skillC.getId(), SKILLVALUE + 3);
			sceneService.saveAnswer(answer);
		}

	}

}
