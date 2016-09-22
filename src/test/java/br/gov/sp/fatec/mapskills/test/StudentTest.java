package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.Login;
import br.gov.sp.fatec.mapskills.domain.student.Student;
import br.gov.sp.fatec.mapskills.domain.student.StudentService;
import br.gov.sp.fatec.mapskills.spring.SpringRootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRootConfig.class, loader = AnnotationConfigContextLoader.class)
public class StudentTest implements ApplicationTest {

	@Autowired
	StudentService service;
	
	@Test
	@Override
	public void save() {
		final Student student = new Student("Name Fake", 2016100010, "1239003400", 1,new Login("nick@fate.sp.gov.br","mudar@123"));
		service.create(student);
		
		assertEquals("Name Fake", service.findById(student.id()).name());

	}

	@Test
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
