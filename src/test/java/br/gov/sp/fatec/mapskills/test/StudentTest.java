package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class StudentTest implements ApplicationTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private InstitutionService institutionService;
	
	@Test
	public void save() throws MapSkillsException {
		final Student student = new Student("1460281423023", "Student Mock", "1289003400", "nick5s2@fate.sp.gov.br", "mudar@123");
		userService.create(student);
		
		assertEquals("Student Mock", userService.findById(student.id()).name());
	}
	
	@Test
	public void saveList() throws MapSkillsException {
		final List<Student> students = new ArrayList<>();
		final Student studentA = new Student("1460281423030", "Student MockA", "1289003400", "studentA@fate.sp.gov.br", "mudar@123");
		final Student studentB = new Student("1460281423031", "Student MockB", "1289003400", "studentB@fate.sp.gov.br", "mudar@123");
		final Student studentC = new Student("1460281423032", "Student MockC", "1289003400", "studentC@fate.sp.gov.br", "mudar@123");
		final Student studentD = new Student("1460281423033", "Student MockD", "1289003400", "studentD@fate.sp.gov.br", "mudar@123");
		students.add(studentA);
		students.add(studentB);
		students.add(studentC);
		students.add(studentD);
		
		userService.create(students);
	
	}
	
	@Test
	public void findAllStudentsByInstitution() {
		assertEquals(4, institutionService.findAllStudentsByInstitution(1).size());
	}

	@Test
	public void update() {
		// TODO Auto-generated method stub

	}

}
