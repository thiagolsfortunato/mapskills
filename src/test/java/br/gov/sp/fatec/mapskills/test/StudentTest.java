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
	@Override
	public void save() {
		final Student student = new Student("Name Fake embedded", 2017008010, "1289003400", 1, "nick5s2@fate.sp.gov.br","mudar@123");
		userService.create(student);
		
		assertEquals("Name Fake embedded", userService.findById(student.id()).name());
	}
	
	@Test
	public void saveList() {
		final List<Student> students = new ArrayList<>();
		final Student studentA = new Student("Name Student A", 2017008011, "1289003400", 1, "nick5s2@fate.sp.gov.br","mudar@123");
		final Student studentB = new Student("Name Student B", 2017008012, "1289003400", 1, "nick5s2@fate.sp.gov.br","mudar@123");
		final Student studentC = new Student("Name Student C", 2017008013, "1289003400", 1, "nick5s2@fate.sp.gov.br","mudar@123");
		final Student studentD = new Student("Name Student D", 2017008014, "1289003400", 1, "nick5s2@fate.sp.gov.br","mudar@123");
		students.add(studentA);
		students.add(studentB);
		students.add(studentC);
		students.add(studentD);
		
		userService.create(students);
		
		//assertEquals(4, institutionService.findAllStudentsByCourse(1, 1));
	}

	@Test
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
