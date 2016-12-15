package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserFactory;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class AdministratorTest extends MapSkillsTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private InstitutionService institutionService;
	
	@Resource
	private Map<ProfileType, UserFactory> userFactory;
	
	@After
	public void cleanTables() {
		super.cleanTables(userService, institutionService);
	}
	
	@Test
	public void findUserByUsernamePassword() throws MapSkillsException {
		final String EXPECTED = "1460281423023"; 
		
		final Mentor mentorSave = new Mentor("Mentor Fatec GRU","marquinho@fatec.sp.gov.br","mudar@123");
		final Institution institutionSave = new Institution("200", "22238846000105","FATEC GRU","Guarulhos", mentorSave);
		institutionService.saveInstitution(institutionSave);
		
		final Student studentSave = new Student(new AcademicRegistry("1460281423023", "146", "028"), "Student MockA", "1289003400", "studentA@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(studentSave);
		
		final User studentUser = userService.findUserByUsernamePassword("studentA@fatec.sp.gov.br", "mudar@123");
		final User mentorUser = userService.findUserByUsernamePassword("marquinho@fatec.sp.gov.br", "mudar@123");
		
		final Student student = userFactory.get(studentUser.getProfile()).create(studentUser);
		final Mentor mentor = userFactory.get(mentorUser.getProfile()).create(mentorUser);
		
		assertEquals(EXPECTED, student.getRa());
		assertEquals("Mentor Fatec GRU", mentor.getName());
	}
	
	@Test
	public void saveAdministrator() {
		final Administrator admin = new Administrator("Administrador", "admin", "admin");
		userService.save(admin);
	}


}
