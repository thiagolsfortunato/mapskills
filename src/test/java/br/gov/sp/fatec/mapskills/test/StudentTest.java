package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class StudentTest implements ApplicationTest {

	@Autowired
	UserService service;
	
	@Test
	@Override
	public void save() {
		final Student student = new Student("Name Fake", 2016708010, "1289003400", 2, "nick4s2@fate.sp.gov.br","mudar@123");
		service.create(student);
		
		assertEquals("Name Fake", service.findById(student.id()).name());

	}

	@Test
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
