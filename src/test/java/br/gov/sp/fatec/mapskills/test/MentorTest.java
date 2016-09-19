package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.domain.Login;
import br.gov.sp.fatec.mapskills.mentor.Institution;
import br.gov.sp.fatec.mapskills.mentor.Mentor;
import br.gov.sp.fatec.mapskills.mentor.MentorService;
import br.gov.sp.fatec.mapskills.spring.SpringRootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRootConfig.class, loader = AnnotationConfigContextLoader.class)
public class MentorTest implements ApplicationTest{
	
	@Autowired
	MentorService service;
	
	@Test
	public void save() {
		final Institution fatec = new Institution("83237522000139", "Jessen Vidal", "São José");
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", new Login("marquinhos@fatec", "Mudar@123"), fatec);
		service.save(mentor);
		
		assertEquals(mentor.id(), service.findById(mentor.id()).id());
	}
	
	@Test
	public void update() {
		final Mentor mentor = service.findById(1);
		mentor.setName("Marcos Silveira");
		mentor.changeInstitution(new Institution("71461173000155","Fatec Jacarei","Jacarei"));
		service.save(mentor);
		
		assertEquals("Marcos Silveira", service.findById(mentor.id()).name());
	}
	

}
